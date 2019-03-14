package com.crk.thrift.client;

import com.crk.thrift.service.HelloService;
import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import org.apache.thrift.TException;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static com.google.common.net.HostAndPort.fromParts;

/**
 * Created by yangjunming on 3/22/16.
 * author: yangjunming@huijiame.com
 */
public class ThriftClientDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException, TException {

		ThriftClientManager clientManager = new ThriftClientManager();
		HelloService helloService = clientManager.createClient(
				new FramedClientConnector(fromParts("localhost", 12335)),
				HelloService.class).get();
		System.out.println(helloService.ping());

		int max = 100000;
		Long start = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			helloService.ping();
		}
		Long end = System.currentTimeMillis();
		Long elapse = end - start;
		int perform = Double.valueOf(max / (elapse / 1000d)).intValue();

		System.out.print("thrift " + max + " 次RPC调用，耗时：" + elapse + "毫秒，平均" + perform + "次/秒");
		clientManager.close();

	}

	public String getImage(String urlStr) throws IOException {

		URL url = new URL(urlStr);
		BufferedImage image = ImageIO.read(url);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", out);
		byte[] data = out.toByteArray();
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		// 返回Base64编码过的字节数组字符串
		String base64Str = encoder.encode(data);

		return base64Str;
	}
}
