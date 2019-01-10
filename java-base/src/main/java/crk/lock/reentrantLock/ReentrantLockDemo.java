package crk.lock.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	private Lock lock = new ReentrantLock();

	class Widget {
		public void doSomething() {
			lock.lock();
			System.out.println("Widget calling doSomething");
			lock.unlock();
		}
	}

	class LoggingWidget extends Widget {
		@Override
		public void doSomething() {
			lock.lock();
			System.out.println("LoggingWidget calling doSomething");
			super.doSomething();
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
		Widget widget = reentrantLockDemo.new LoggingWidget();
		widget.doSomething();
	}

}
