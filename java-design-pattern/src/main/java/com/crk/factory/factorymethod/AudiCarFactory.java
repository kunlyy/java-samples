package com.crk.factory.factorymethod;

/**
 * 工厂方法是把工厂生产产品的责任具体到各个子类工厂实现，总工厂只是定义抽象的方法
 * Created by chenrongkun on 2019/2/12.
 */
public class AudiCarFactory extends CarFactory{

	@Override
	public Car createCar(String name) {
		return new Banz(name);
	}
}
