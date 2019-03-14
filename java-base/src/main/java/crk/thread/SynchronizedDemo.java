package crk.thread;

public class SynchronizedDemo {

	public static void main(String[] args) {

//		exec1();

		exec2();

	}

	public static void exec1() {
		/**
		 * 代码中countAdd是一个synchronized的，printCount是非synchronized的。
		 * 从执行的结果中可以看出一个线程访问一个对象的synchronized代码块时，
		 * 别的线程可以访问该对象的非synchronized代码块而不受阻塞,
		 * 这时候无论是synchronized(this)或者是synchronized(class)都是同样的效果。
		 */
		Counter counter = new Counter();
		Thread thread1 = new Thread(counter, "A");
		Thread thread2 = new Thread(counter, "B");
		Thread thread3 = new Thread(counter, "C");
		thread1.start();
		thread2.start();
		thread3.start();
	}

	public static void exec2() {
		/**
		 * 此执行方法和exec1()的不同点是生成了多个counter对象。
		 * 从执行结果来看非同步代码块也是不会受其他对象同步代码块的影响的。
		 * 但是在同步代码块中，使用synchronized(this)和synchronized(class)，对不同的对象有不同的影响，
		 * this对不同对象是可以并发执行的，不会阻塞的；class则是不同线程对同步代码块会产生阻塞。
		 */
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
		Counter counter3 = new Counter();
		Thread thread1 = new Thread(counter1, "A1");
		Thread thread2 = new Thread(counter2, "A2");
		Thread thread3 = new Thread(counter3, "C1");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}



class Counter implements Runnable {
	private int count;

	public Counter() {
		count = 0;
	}

	public void countAdd() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
	public void printCount() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + " count:" + (count--));
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void countSub() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " count:" + count);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.startsWith("A")) {
			countAdd();
		} else if (threadName.startsWith("B")) {
			printCount();
		} else if (threadName.startsWith("C")) {
			countSub();
		}
	}
}
