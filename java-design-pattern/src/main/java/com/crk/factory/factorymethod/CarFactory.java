package com.crk.factory.factorymethod;

/**
 * 抽象汽车工厂
 * Created by chenrongkun on 2019/2/12.
 */
public abstract class CarFactory {

	/**
	 * 生产汽车抽象方法
	 * @param name
	 * @return
	 */
	public abstract Car createCar(String name);
}
