package crk.thread;

public class JoinTest implements Runnable {

	public static int a=0;
	
	@Override
	public void run() {
		for(int i=0;i<500000;i++){
			a++;
		}

	}
	
	public static void main(String[] args) throws Exception {
		JoinTest joinTest = new JoinTest();
		Thread t = new Thread(joinTest);
		t.start();
		t.join();
		System.out.println(a);
	}

}
