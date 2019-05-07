package crk.algorithm;

/**
 * 佛波那契数列求解
 *
 * Created by chenrongkun on 2019/4/29.
 */
public class Fobonaqi {

	/**
	 * 递归方式
	 *
	 * @param n
	 * @return
	 */
	public static int fobonaqiSolution(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fobonaqiSolution(n - 1) + fobonaqiSolution(n - 2);
	}

	/**
	 * 循环方式
	 *
	 * @param n
	 * @return
	 */
	public static int fobonaqiSolution2(int n) {
		int count = 0;
		int preOne = 1;
		int preTwo = 1;
		for (int i = 3; i <= n; i++) {
			count = preTwo + preOne;
			preTwo = preOne;
			preOne = count;
		}
		return count;
	}

	public static void main(String[] args) {
		int month = 10;
		int count = fobonaqiSolution(month);
		int count2 = fobonaqiSolution2(month);
		System.out.println("method1->month:" + month + ",count:" + count);
		System.out.println("method2->month:" + month + ",count:" + count2);
	}
}
