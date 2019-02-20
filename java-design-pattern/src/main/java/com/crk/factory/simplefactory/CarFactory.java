package com.crk.factory.simplefactory;

/**
 * 汽车工厂，负责生产汽车
 * Created by chenrongkun on 2019/2/12.
 */
public class CarFactory {

	public Car createCar(String name) {
		switch (name) {
			case "banz":
				return new Banz(name);
			case "bmw":
				return new Bmw(name);
			case "audi":
				return new Audi(name);
		}
		return null;
	}
}
