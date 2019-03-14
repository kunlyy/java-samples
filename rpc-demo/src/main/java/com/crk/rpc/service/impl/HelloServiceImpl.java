package com.crk.rpc.service.impl;


import com.crk.rpc.service.HelloService;

/**
 * Created by chenrongkun on 2019/2/12.
 */
public class HelloServiceImpl implements HelloService {
	@Override
	public String hello(String string){
		return "hello netty-->" + string;
	}
}
