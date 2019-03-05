package crk.thread;

public class SynchronizedDemo2 implements Runnable {

	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public SynchronizedDemo2(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		if(index == 1){
			Test1();
		}else {
			Test2();
		}

	}

	private void Test1() {
		System.out.println("test1:"+System.currentTimeMillis());
		System.out.println("Thread a");
		synchronized (SynchronizedDemo2.class) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " synchronized loop test1 " + i);
			}
		}
	}
	
	private void Test2() {
		System.out.println("test2:" + System.currentTimeMillis());
		System.out.println("Thread b");
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " synchronized loop test2 " + i);
			}
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo2 t1 = new SynchronizedDemo2(1);
		SynchronizedDemo2 t2 = new SynchronizedDemo2(1);
		//t1.setIndex(1);
		Thread ta = new Thread(t1, "A");
		Thread tb = new Thread(t2, "B");
		ta.start();
		System.out.println("main:"+System.currentTimeMillis());
		t1.setIndex(2);
		tb.start();

	}

}