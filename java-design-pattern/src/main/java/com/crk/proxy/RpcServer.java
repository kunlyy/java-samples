package com.crk.proxy;

import java.io.IOException;

public class RpcServer {

	public static void main(String[] args) {
		try {
			//暴露服务
			HelloService service = new HelloServiceImpl();
//			RpcFramework.export(service, 8989);
			RpcFrameworkByNio.export(service, 8989);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 服务端对接口的具体实现
	 */
	private static class HelloServiceImpl implements HelloService {
		@Override
		public String sayHello(String msg) {
			System.out.println(this.getClass().getName());
			String result =  "hello world " + msg;
			System.out.println(result);
			return result;
		}
	}
}
