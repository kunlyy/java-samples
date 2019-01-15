package crk.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 找到速度最快的5辆车，从小到大输入
 * PriorityQueue 不允许保存null
 * Created by chenrongkun on 2019/1/15.
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Car> queue = new PriorityQueue<>(5, Comparator.comparingInt(Car::getSpeed));

		for (int i = 0; i < 50; i ++) {
			queue.add(new Car("car" + i, new Random().nextInt(200)));
			if (i > 4) {
				queue.poll();
			}
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().toString());
		}
	}
}

@Data
@AllArgsConstructor
class Car {

	private String name;

	private Integer speed;
}
