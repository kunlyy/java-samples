package com.crk.rpc.server;

import com.crk.rpc.nettyutils.NettyServer;

/**
 * Created by chenrongkun on 2019/2/21.
 */
public class ServerDemo {

	public static void main(String[] args) {
		NettyServer.startServer("localhost", 8088);
		System.out.println("服务启动");
	}
}
