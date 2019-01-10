package crk.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用阻塞队列实现生产者-消费者模型
 * @author  kun
 *
 */

public class ProducerConsumerDemo2 {
	
	private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
	
	public static void main(String[] args) {
		ProducerConsumerDemo2 demo2 = new ProducerConsumerDemo2();
		Producer producer = demo2.new Producer();
		Consumer consumer = demo2.new Consumer();
		
		producer.start();
		consumer.start();
		
	}
	
	
	class Producer extends Thread{

		@Override
		public void run() {
			produce();
			
		}
		
		private void produce(){
			while(true){
				try{
					queue.put(new String("1"));
					System.out.println("生产成功!空余空间为："+(10-queue.size()));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	class Consumer extends Thread{

		@Override
		public void run() {
			comsume();
		}
		
		private void comsume(){
			while(true){
				try{
					queue.take();
					System.out.println("消费成功!队列剩余为"+(queue.size()));
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
