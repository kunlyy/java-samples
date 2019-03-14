package com.crk.factory.abstractfactory;

/**
 *  抽象工厂模式为创建一组对象提供了一种解决方案。与工厂方法模式相比，抽象工厂模式中的具体工厂不只是创建一种产品，它负责创建一族产品。
 *  所以抽象工厂重点突出工厂定义的是产品族（组），而不是单一产品的概念
 *  参考：https://blog.csdn.net/janice0529/article/details/40268217
 *
 * Created by chenrongkun on 2019/3/13.
 */
public class Client {

	public static void main(String[] args) {
		/**
		 * HUAWEI 的工厂就生产HUAWEI的配件
		 */
		AbstractFactory huaweiFactory = new HuaweiFactory();
		Camera camera = huaweiFactory.createCamera();
		camera.photography();
		Screen screen = huaweiFactory.createScreen();
		screen.luminance();

		System.out.println("----------------------------------");
		/**
		 * XIAOMI的工厂就生成小米的配置
		 */
		AbstractFactory xiaomiFactory = new XiaomiFactory();
		Camera camera1 = xiaomiFactory.createCamera();
		camera1.photography();
		Screen screen1 = xiaomiFactory.createScreen();
		screen1.luminance();
	}
}
