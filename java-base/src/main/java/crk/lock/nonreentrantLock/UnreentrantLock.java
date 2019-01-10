package crk.lock.nonreentrantLock;

import java.util.concurrent.atomic.AtomicReference;

public class UnreentrantLock {

	private AtomicReference<Thread> owner = new AtomicReference<Thread>();

	public void lock() {
		Thread current = Thread.currentThread();
		//这句是很经典的“自旋”语法，AtomicInteger中也有
		for (;;) {
			if (!owner.compareAndSet(null, current)) {
            }
        }

	}

	public void unlock() {
		Thread current = Thread.currentThread();
		owner.compareAndSet(current, null);
	}

	public static void main(String[] args) {
		UnreentrantLock lock = new UnreentrantLock();
		lock.lock();
		System.out.println(1234);
		lock.lock();
//		SpinLock1 lock1 = new SpinLock1();
//		lock1.lock();
//		lock1.lock();
//
//		lock1.unlock();
//		lock1.unlock();

	}
}

class SpinLock1 {
	private AtomicReference<Thread> owner = new AtomicReference<>();
	private int count = 0;

	public void lock() {
		Thread current = Thread.currentThread();
		if (current == owner.get()) {
			count++;
			return;
		}

		while (!owner.compareAndSet(null, current)) {

		}
	}

	public void unlock() {
		Thread current = Thread.currentThread();
		if (current == owner.get()) {
			if (count != 0) {
				count--;
			} else {
				owner.compareAndSet(current, null);
			}

		}

	}
}
