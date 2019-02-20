package com.crk.factory.factorymethod;

/**
 * 客户端
 * Created by chenrongkun on 2019/2/12.
 */
public class Client {

	/**
	 * 客户端主线程负责向工厂提出需要生产的产品
	 * @param args
	 */
	public static void main(String[] args) {
		String carName = "banz";
		Car car = new BanzCarFactory().createCar(carName);
		System.out.println(carName + ":" + car.price());
	}
}
