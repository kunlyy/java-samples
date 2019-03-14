package com.crk.factory.abstractfactory;

/**
 * 定义具体的工厂类。这工厂是可以生产一组产品。这个是工厂方法的区别：工厂方法只能是生产一个产品，二抽象工厂是对产品组的生产
 * Created by chenrongkun on 2019/3/13.
 */
public class HuaweiFactory implements AbstractFactory {

	@Override
	public Camera createCamera() {
		return new HuaweiCarmera();
	}

	@Override
	public Screen createScreen() {
		return new HuaweiScreen();
	}
}
