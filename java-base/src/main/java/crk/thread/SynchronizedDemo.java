package crk.thread;

public class SynchronizedDemo {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Foo(1));
		Thread t2 = new Thread(new Foo(2));
		Thread t3 = new Thread(new Foo(3));
		t1.start();
		t2.start();
		t3.start();
	}

}


class Foo implements Runnable{
	
	private int index;
	
	public volatile int total =0;

	public Foo(int i){
		this.index = i;
	}
	
	@Override
	public void run() {
		if(index == 1){
			this.Foo1();
		}else if(index == 2){
			this.Foo2();
		}else {
			this.Foo3();
		}
		
	}
	
	public void Foo1(){
		System.out.println("Foo1");
	}
	
	public void Foo2() {
		System.out.println("Foo2 start");
		long start = System.currentTimeMillis();
		long end = 0L;
		synchronized (Foo.class) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(total <10){
				int i=total;
				for(;i<=10;i++){
					total++;
				}
			}else {
				System.out.println("Foo2=="+total);
			}
			end = System.currentTimeMillis();
			System.out.println("Foo2");
		}
		System.out.println(end - start);
	}
	
	public void Foo3(){
		System.err.println("Foo3 start");
		for(int i=0;i<2000000;i++){
			i++;
		}
		synchronized (Foo.class) {
			for(int i=0;i<=10;i++){
				total++;
			}
			System.out.println("Foo3=="+total);
		}
	}
	
}