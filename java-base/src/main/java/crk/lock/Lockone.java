package crk.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenrongkun on 2018/5/17.
 */
public class Lockone implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName());
		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {
		Lockone lock = new Lockone();
		Thread t1 = new Thread(lock);
		t1.setName("t1 lock");
		Thread t2 = new Thread(lock);
		t2.setName("t2 lock");
		t1.start();
		t2.start();
	}
}
