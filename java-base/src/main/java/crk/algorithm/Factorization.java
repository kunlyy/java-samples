package crk.algorithm;

/**
 * 分解质因数
 * Created by chenrongkun on 2019/4/30.
 */
public class Factorization {

	public static void factorization(int num) {
		if (num <= 1) {
			System.out.println("no factory");
		}
		System.out.print(num + "=");
		int i = 2;
		while (i <= num) {
			if (i == num) {
				System.out.print(i);
				break;
			}
			if (num % i == 0) {
				System.out.print(i + "*");
				num = num / i;
			} else {
				i ++;
			}
		}
	}

	public static void main(String[] args) {
		factorization(24800351);
	}
}
