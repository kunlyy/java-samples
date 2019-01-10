package crk.thread;

public class RaceCondition {
	
	public  boolean flag = false;
	
	/**
	 * 如果flag变量没有声明为volatile，doSomething方法体内没有需要执行的语句，jvm会优化这块代码
	 */
	public static void doSomething(){
		//System.out.println("doSomething");
	}
	
	public static void main(String[] args) throws InterruptedException {
		final RaceCondition rc = new RaceCondition();
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				while(!rc.flag){
					doSomething();
					//System.out.println("runnable");
				}
			}
			
		}).start();
		
		Thread.sleep(20);
        rc.flag = true;
        System.out.println("Done set to true");
	}
	

}
