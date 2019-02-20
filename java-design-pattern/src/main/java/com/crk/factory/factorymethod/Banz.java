package com.crk.factory.factorymethod;

/**
 * 汽车的具体实现类
 * Created by chenrongkun on 2019/2/12.
 */
public class Banz extends Car {

	private String name;

	public Banz(String name) {
		this.name = name;
	}

	@Override
	public int price() {
		return 1000;
	}
}
