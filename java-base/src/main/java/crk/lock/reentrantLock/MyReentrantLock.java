package crk.lock.reentrantLock;

/**
 * Created by chenrongkun on 2018/5/17.
 */
public class MyReentrantLock {
	private boolean isLock = false;
	private Thread lockBy;
	private int lockCount = 0;

	public synchronized void lock() throws InterruptedException {
		Thread currentThread = Thread.currentThread();
		while (isLock && lockBy != currentThread) {
			wait();
		}
		isLock = true;
		lockBy = currentThread;
		lockCount ++;
	}

	public synchronized void unLock() {
		if (Thread.currentThread() == this.lockBy) {

		}

	}
}
