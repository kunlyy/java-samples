package com.crk.factory.abstractfactory;

/**
 * Created by chenrongkun on 2019/3/13.
 */
public class XiaomiFactory implements AbstractFactory {
	@Override
	public Camera createCamera() {
		return new XiaomiCamera();
	}

	@Override
	public Screen createScreen() {
		return new XiaomiScreen();
	}
}
