package com.crk.rpc.client;

import com.crk.rpc.nettyutils.NettyClient;
import com.crk.rpc.service.HelloService;

/**
 * Created by chenrongkun on 2019/2/21.
 */
public class ClientDemo {

	public static final String providerName = "HelloService#ping#";

	public static void main(String[] args) throws InterruptedException {
		NettyClient consumer = new NettyClient();
		// 创建一个代理对象
		HelloService service = (HelloService) consumer.getBean(HelloService.class, providerName);

		int max = 100000;
		Long start = System.currentTimeMillis();
		for (int i = 0; i < max; i++) {
			service.hello("hello world");
		}
		Long end = System.currentTimeMillis();
		Long elapse = end - start;
		int perform = Double.valueOf(max / (elapse / 1000d)).intValue();

		System.out.print("netty " + max + " 次RPC调用，耗时：" + elapse + "毫秒，平均" + perform + "次/秒");
	}
}
