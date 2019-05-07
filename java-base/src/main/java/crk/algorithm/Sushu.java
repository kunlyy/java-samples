package crk.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * 素数
 * Created by chenrongkun on 2019/4/29.
 */
public class Sushu {

	/**
	 * 获取给定区间（闭区间）的所有素数
	 *
	 * @param startNum 开始
	 * @param endNum 结束
	 * @return
	 */
	public static List<Integer> getSushu(int startNum, int endNum) {
		if (startNum > endNum) {
			return new ArrayList<>();
		}
		if (startNum <= 2) {
			startNum = 2;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = startNum; i <= endNum; i++) {
			int temp = i / 2;
			boolean sushu = true;
			for (int j = 2; j <= temp; j++) {
				if (i % j == 0) {
					sushu = false;
				}
			}
			if (sushu) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> sushu = getSushu(4000, 5000);
		System.out.println("sushu list size = " + sushu.size());
		sushu.forEach(item -> {
			System.out.println(item);
		});
	}
}
