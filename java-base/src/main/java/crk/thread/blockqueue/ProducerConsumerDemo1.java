package crk.thread.blockqueue;

import java.util.PriorityQueue;

/**
 * 使用Object的wait()和notify()方法模拟生产者消费者
 *
 * @author  kun
 *
 */

public class ProducerConsumerDemo1 {

	private PriorityQueue<String> queue = new PriorityQueue<String>(10);

	public static void main(String[] args) {
		ProducerConsumerDemo1 demo1 = new ProducerConsumerDemo1();
		Producer producer = demo1.new Producer();
		Consumer consumer = demo1.new Consumer();

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
				synchronized (queue) {
					while(queue.size() == 10){
						try{
							System.out.println("队列满，等待有空余空间");
							queue.wait();
						}catch(Exception e){
							queue.notify();
							e.printStackTrace();
						}
					}
					queue.offer(new String("produce"));
					queue.notify();
					System.out.println("生产成功!空余空间为："+(10-queue.size()));
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
				synchronized (queue) {
					while(queue.isEmpty()){
						try{
							System.out.println("队列空，等待数据");
							queue.wait();
						}catch(Exception e){
							e.printStackTrace();
							queue.notify();
						}
					}
					queue.poll();
					queue.notify();
					System.out.println("消费成功!队列剩余为"+(queue.size()));
				}
			}
		}
	}

}
