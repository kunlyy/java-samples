package com.crk.proxy;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.zip.GZIPOutputStream;

public class Client implements Runnable {
	Selector selector;

	boolean running;

	SocketChannel sc;

	public Client() {
		running = true;

	}

	public void init() {
		try {
			sc = SocketChannel.open();
			sc.configureBlocking(false);
			sc.connect(new InetSocketAddress("localhost", 2345));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		new Thread(client).start();
	}


	public void execute() {
		try {
			while (!sc.finishConnect()) {
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		ReadKeyBoard rkb = new ReadKeyBoard();
		new Thread(rkb).start();

//		while (running) {
//			try {
//				ByteBuffer buffer = ByteBuffer.allocate(1024);
//				buffer.clear();
//				StringBuffer sb = new StringBuffer();
//				Thread.sleep(500);
//
//				while ((num = sc.read(buffer)) > 0) {
//					if (num == -1) {
//						sc.close();
//					}
//					sb.append(new String(buffer.array(), 0, num));
//					buffer.clear();
//				}
//				if (sb.length() > 0) System.out.println(sb.toString());
//				if (sb.toString().toLowerCase().trim().equals("bye")) {
//					System.out.println("closed....");
//					sc.close();
//					sc.socket().close();
//					rkb.close();
//					running = false;
//				}
//			} catch (InterruptedException ex) {
//				ex.printStackTrace();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
	}

	@Override
	public void run() {
		init();
		execute();
	}


	public byte[] serialize(Object obj) {
		try {
			ByteArrayOutputStream bis = new ByteArrayOutputStream();
			ObjectOutputStream stream = new ObjectOutputStream(bis);
			stream.writeObject(obj);
			stream.close();
			byte[] bytes = bis.toByteArray();
			//使用zip压缩，缩小网络包
			if(bytes!=null&&bytes.length>0){
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				try {
					GZIPOutputStream gos = new GZIPOutputStream(bos);
					gos.write(bytes);
					gos.close();
					return bos.toByteArray();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new byte[0];
	}

	class ReadKeyBoard implements Runnable {
		boolean running2 = true;

		public ReadKeyBoard() {}

		public void close() {
			running2 = false;
		}

		@Override
		public void run() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while (running2) {
				try {
					System.out.println("enter some commands:");
					String str = reader.readLine();
					System.out.println("get commands:" + str);
					User user = new User();
					user.setId("sss");
					sc.write(ByteBuffer.wrap(serialize(user)));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
} 