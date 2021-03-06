package com.crk.factory.simplefactory;

/**
 * 客户端
 * Created by chenrongkun on 2019/2/12.
 */
public class Client {

	private static CarFactory carFactory = new CarFactory();

	/**
	 * 客户端主线程负责向工厂提出需要生产的产品
	 * @param args
	 */
	public static void main(String[] args) {
		String carName = "banz";
		Car car = carFactory.createCar(carName);
		System.out.println(carName + ":" + car.price());
	}
}
