package com.crk.factory.simplefactory;

/**
 * 汽车的具体实现类
 * Created by chenrongkun on 2019/2/12.
 */
public class Banz extends Car{

	private String name;

	public Banz(String name) {
		this.name = name;
	}

	@Override
	public int price() {
		return 1000;
	}

	@Override
	public int spreed() {
		return 100;
	}
}
