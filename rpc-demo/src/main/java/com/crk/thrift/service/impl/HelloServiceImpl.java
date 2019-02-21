package com.crk.thrift.service.impl;

import com.crk.thrift.service.HelloService;
import org.apache.thrift.TException;

/**
 * Created by chenrongkun on 2019/2/12.
 */
public class HelloServiceImpl implements HelloService{
	@Override
	public String ping() throws TException {
		return "pong";
	}
}
