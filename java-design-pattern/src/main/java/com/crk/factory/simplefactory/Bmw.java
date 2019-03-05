package com.crk.factory.simplefactory;

/**
 * 汽车的具体实现类
 * Created by chenrongkun on 2019/2/12.
 */
public class Bmw extends Car{

	private String name;

	public Bmw(String name) {
		this.name = name;
	}

	@Override
	public int price() {
		return 1001;
	}

	@Override
	public int spreed() {
		return 101;
	}
}
