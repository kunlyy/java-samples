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

	public void run() {
		if(index == 1){
			Test1();
		}else {
			Test2();
		}

	}

	private void Test1() {
		System.out.println("Thread a");
		synchronized (SynchronizedDemo2.class) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " synchronized loop test1 " + i);
			}
		}
	}
	
	private void Test2() {
		System.out.println("Thread b");
		synchronized (SynchronizedDemo2.class) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " synchronized loop test2 " + i);
			}
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo2 t1 = new SynchronizedDemo2(1);
		//t1.setIndex(1);
		Thread ta = new Thread(t1, "A");
		ta.start();
		t1.setIndex(2);
		Thread tb = new Thread(t1, "B");
		tb.start();

	}

}