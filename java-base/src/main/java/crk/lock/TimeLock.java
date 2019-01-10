package crk.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			if (lock.tryLock(500L, TimeUnit.MICROSECONDS)) {
				Thread.sleep(600);
			} else {
				System.out.println("获取失败");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		TimeLock timeLock = new TimeLock();
		Thread t1 = new Thread(timeLock);
		Thread t2 = new Thread(timeLock);
		t1.start();
		t2.start();
	}
}