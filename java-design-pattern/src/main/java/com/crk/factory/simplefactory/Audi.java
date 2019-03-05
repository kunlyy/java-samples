package com.crk.factory.simplefactory;

/**
 * 汽车的具体实现类
 * Created by chenrongkun on 2019/2/12.
 */
public class Audi extends Car{

	private String name;

	public Audi(String name) {
		this.name = name;
	}

	@Override
	public int price() {
		return 1002;
	}

	@Override
	public int spreed() {
		return 102;
	}
}
