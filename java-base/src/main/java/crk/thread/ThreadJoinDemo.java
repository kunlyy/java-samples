package crk.thread;

public class ThreadJoinDemo {
	
	public static void main(String[] args) throws Exception {
		//NumberThread thread = new NumberThread(1,10);
		Thread t1 = new Thread(new NumberThread(1,10));
		Thread t2 = new Thread(new NumberThread(10,20));
		t1.start();
		t1.join(90);
		t2.start();
	}
	

}

class NumberThread implements Runnable{
	
	private int min;
	private int max;
	
	public NumberThread(int min,int max){
		this.min = min;
		this.max = max;
	}
	@Override
	public void run() {
		for(int i=min;i<max;i++){
			System.out.println(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}