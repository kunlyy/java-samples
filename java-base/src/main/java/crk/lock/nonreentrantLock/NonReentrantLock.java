package crk.lock.nonreentrantLock;

/**
 * Created by chenrongkun on 2018/5/17.
 * 不可重入锁
 */
public class NonReentrantLock {
	private boolean lock = false;

	public synchronized void lock() throws InterruptedException {
		while (lock) {
			wait();
		}
		lock = true;
	}

	public synchronized void unLock() {
		lock = false;
		notifyAll();
	}

}
