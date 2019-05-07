package crk.algorithm.leetcode;

/**
 * https://leetcode-cn.com/classic/problems/happy-number/description/
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * Created by chenrongkun on 2019/5/7.
 */
public class No202 {

	/**
	 * “快乐数”，如果存在两个结果是相同的，那肯定不是“快乐数”。判断一个队列（环）中是否有相同的数，都是可以用快慢指针。
	 * 所以，“快乐数”也是可以使用快慢指针实现 TODO
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean happy = solution.isHappy(19);
		System.out.println(happy);
	}
}

class Solution {
	public boolean isHappy(int n) {
		if (n <= 0) {
			return false;
		}
		int result = n;
		while (true) {
			 result = getResult(result);
			if (result > 243) {
				continue;
			} else if (result == 4 || result == 16 || result == 37 || result == 58 ||
					result == 89 || result == 145 || result == 42 || result == 20) {
				return false;
			} else if (result == 1) {
				return true;
			}
		}
	}

	/**
	 * 获取输入n拆解后的平方和
	 * @param n
	 * @return
	 */
	private int getResult(int n) {
		int result = 0;
		while (n > 0) {
			result += Math.pow(n % 10, 2);
			n = n / 10;
		}
		return result;
	}
}
