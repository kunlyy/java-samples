package crk.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInter implements Runnable {
	public static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		try {
			lock.lockInterruptibly();
//            lock.lock();
			System.out.println(Thread.currentThread().getName() + "running");
			Thread.sleep(500);
			lock.unlock();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
	}

	public static void main(String[] args) {
		LockInter mm = new LockInter();
		Thread t1 = new Thread(mm);
		Thread t2 = new Thread(mm);
		t1.start();
		t2.start();
		t2.interrupt();
	}


}