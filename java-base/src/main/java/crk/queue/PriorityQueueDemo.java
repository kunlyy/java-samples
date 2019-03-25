package crk.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 参考：https://www.cnblogs.com/gnivor/p/4841191.html
 *
 * 实际上是一个堆（不指定Comparator时默认为最小堆）。可以用来实现top K问题
 * 队列既可以根据元素的自然顺序来排序，也可以根据 Comparator来设置排序规则。
 * 队列的头是按指定排序方式的最小元素。如果多个元素都是最小值，则头是其中一个元素。
 * 新建对象的时候可以指定一个初始容量，其容量会自动增加。

 * 注意1：该队列是用数组实现，但是数组大小可以动态增加，容量无限。

 * 注意2：队列的实现不是同步的。不是线程安全的。如果多个线程中的任意线程从结构上修改了列表， 则这些线程不应同时访问 PriorityQueue实例。保证线程安全可以使用PriorityBlockingQueue 类。

 * 注意3：不允许使用 null 元素。

 * 注意4：插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；
 * remove(Object) 和 contains(Object) 时间复杂度为O(n)；
 * 检索方法（peek、element 和 size）时间复杂度为常量。

 * 注意5：方法iterator()中提供的迭代器并不保证以有序的方式遍历优先级队列中的元素。（原因可参考PriorityQueue的内部实现）
 * 如果需要按顺序遍历，可用Arrays.sort(pq.toArray())。

 * 注意6：可以在构造函数中指定如何排序。如：
 * PriorityQueue()
 * 使用默认的初始容量（11）创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
 * PriorityQueue(int initialCapacity)
 * 使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
 * 使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。

 * 注意7：此类及其迭代器实现了 Collection 和 Iterator 接口的所有可选 方法。
 *
 * 例子：
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
