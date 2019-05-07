package com.crk.proxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chenrongkun on 2019/3/26.
 */
public class RpcFrameworkByNio {

//	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
//			Runtime.getRuntime().availableProcessors(),
//			Runtime.getRuntime().availableProcessors() * 2,
//			5000,
//			TimeUnit.MICROSECONDS,
//			new ArrayBlockingQueue<>(50));


	public static void export(final Object service, int port) throws IOException {
		if (service == null) {
			throw new IllegalArgumentException("service is null");
		}
		System.out.println("Export service " + service.getClass().getName() + " on port " + port);

		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(port));
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (selector.select() > 0) {
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = keys.iterator();
			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				keyIterator.remove();
				if (key.isAcceptable()) {
					ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
					SocketChannel socketChannel = acceptServerSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				} else if (key.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					int count = socketChannel.read(byteBuffer);
					byteBuffer.flip();


					String receiveData = Charset.forName("UTF-8").decode(byteBuffer).toString();
					System.out.println(receiveData);

					if (count <=0) {
						socketChannel.close();
						key.cancel();
						continue;
					}
				}
				keys.remove(key);
			}
		}
	}

	public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws IOException {
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (proxy, method, arguments) -> {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress(host, port));
			System.out.println("与服务器的连接建立成功");
			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();

				while (it.hasNext()) {
					SelectionKey key = it.next();
					it.remove();
					if (key.isWritable()) {
						SocketChannel channel = (SocketChannel) key.channel();

						MethodDTO dto = new MethodDTO();
						dto.setMethodName(method.getName().getBytes());
						dto.setParameterTypes(method.getParameterTypes());
						dto.setArguments(arguments);

						ByteArrayOutputStream bOut = new ByteArrayOutputStream();
						ObjectOutputStream out = new ObjectOutputStream(bOut);
						out.writeObject(dto);
						out.flush();

						channel.write(ByteBuffer.wrap(bOut.toByteArray()));

//						ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
//						sendBuffer.put(method.getName().getBytes());
//						sendBuffer.flip(); //设置写
//						while (sendBuffer.hasRemaining()) {
//							channel.write(sendBuffer);
//						}
//						sendBuffer.compact();
					}
				}
			}
			return null;
		});

	}
}
