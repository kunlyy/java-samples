package com.crk.factory.abstractfactory;

/**
 * 抽象工厂，定义工厂的一组行为
 * Created by chenrongkun on 2019/3/13.
 */
public interface AbstractFactory {

	/**
	 *  抽象生产camera
	 * @return
	 */
	Camera createCamera();

	/**
	 *  抽象生产screen
	 * @return
	 */
	Screen createScreen();
}
