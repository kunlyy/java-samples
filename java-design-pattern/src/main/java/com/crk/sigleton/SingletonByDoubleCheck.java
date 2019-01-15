package com.crk.sigleton;

/**
 * 双层检查模式的单例。线程安全
 * Created by chenrongkun on 2019/1/15.
 */
public class SingletonByDoubleCheck {

	private SingletonByDoubleCheck() {}

	/**
	 * 使用volatile关键字是避免在new对象的时候是非原子性的。有可能在new对象时候创建的对象不完整而出现不必要的线程错乱问题
	 */
	private static volatile SingletonByDoubleCheck instance = null;

	public static SingletonByDoubleCheck getInstance() {
		if (instance == null) {
			synchronized (SingletonByDoubleCheck.class) {
				if (instance == null) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new SingletonByDoubleCheck();
				}
			}
		}
		return instance;
	}


	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				SingletonByDoubleCheck instance = SingletonByDoubleCheck.getInstance();
				System.out.println(Thread.currentThread().getId() + "**" +
						Thread.currentThread().getName() + "**" + instance);
			}).start();
		}
	}
}
