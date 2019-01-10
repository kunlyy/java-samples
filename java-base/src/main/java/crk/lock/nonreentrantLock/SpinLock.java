package crk.lock.nonreentrantLock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	private AtomicReference<Thread> sign = new AtomicReference<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null,current)){
        }
    }
    public void unlock(){
        Thread cur = Thread.currentThread();
        sign.compareAndSet(cur,null);
    }
}


