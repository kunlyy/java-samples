package crk.lock.reentrantLock;

public class SynchronizedDemo {
	class Widget {
		public synchronized void doSomething() {
			System.out.println("Widget calling doSomething...");
		}
	}

	class LoggingWidget extends Widget {
		@Override
		public synchronized void doSomething() {
			System.out.println("LoggingWidget calling doSomething");
			super.doSomething();
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
		Widget widget = synchronizedDemo.new LoggingWidget();
		widget.doSomething();
	}
}
