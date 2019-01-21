package com.crk.singleton;

/**
 * 通过类实例的初始化实现单例模式，线程安全
 * Created by chenrongkun on 2019/1/15.
 */
public class SingletonByClassHolder {

	private SingletonByClassHolder(){

	}

	private static class ClassHolder {
		private static SingletonByClassHolder instance = new SingletonByClassHolder();
	}

	public static SingletonByClassHolder getInstance() {
		return ClassHolder.instance;
	}


	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				SingletonByClassHolder singletonWithClassHolder = SingletonByClassHolder.getInstance();
				System.out.println(Thread.currentThread().getId() + "**" +
						Thread.currentThread().getName() + "**" + singletonWithClassHolder);
			}).start();
		}
	}

}
