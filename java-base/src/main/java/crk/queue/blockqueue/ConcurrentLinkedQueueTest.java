package crk.queue.blockqueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentLinkedQueueTest {

	private static int count = 3;

	//private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

	private static CountDownLatch latch = new CountDownLatch(count);

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(count);
		ConcurrentLinkedQueueTest.offer();
		for(int i=0;i<count;i++){
			executorService.submit(new Poll());
		}
		latch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("消费完毕!时间为："+ (endTime - startTime));
		executorService.shutdown();
	}

	/**
	 * 生产
	 */
	private static void offer(){
		for(int i=0;i<100000;i++){
			queue.offer(i);
		}
		System.out.println("生产完毕!总量："+ queue.size());
	}

	static class Poll implements Runnable{

		@Override
		public void run() {
			try{
				//while(queue.size()>0){
				while(!queue.isEmpty()){
					queue.poll();
					//System.out.println(Thread.currentThread().getName()+"消费了，剩余量："+ (100 - queue.size()));
				}
				latch.countDown();
			}catch(Exception e){
				e.printStackTrace();
			}

		}

	}

}
