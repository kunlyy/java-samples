package crk.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 * 水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
 * Created by chenrongkun on 2019/4/30.
 */
public class NarcissisticNumber {

	public static List<Integer> getNarcissisticNumbers() {
		List<Integer> result = new ArrayList<>();
		for (int i = 100; i < 1000; i++) {
			int hundreds = i / 100;
			int decade = i % 100 / 10;
			int unit = i % 10;
			if (Math.pow(hundreds, 3) + Math.pow(decade, 3) + Math.pow(unit, 3) == i) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> narcissisticNumbers = getNarcissisticNumbers();
		narcissisticNumbers.forEach(item ->
				System.out.println(item)
		);
	}
}
