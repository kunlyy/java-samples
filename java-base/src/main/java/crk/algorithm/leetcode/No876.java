package crk.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/description/
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定链表的结点数介于 1 和 100 之间。
 * <p>
 * Created by chenrongkun on 2019/5/7.
 */
public class No876 {

	public static void main(String[] args) {
		ListNode head = new No876().new ListNode(1, new No876().new ListNode(2, new No876().new ListNode(3,
				new No876().new ListNode(6, new No876().new ListNode(4,
						new No876().new ListNode(5, new No876().new ListNode(7, null)))))));
		Solution2 solution = new No876().new Solution2();
		ListNode middleNode = solution.middleNode(head);
		System.out.println(middleNode.val);
	}

	/**
	 * 常规暴力解法
	 */
	class Solution1 {
		public ListNode middleNode(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			int size = 0;
			ListNode tempNode = head;
			while (tempNode.next != null) {
				size ++;
				tempNode = tempNode.next;
			}
			int mid = size % 2 == 0 ? size / 2 : size / 2 + 1;
			for (int i = 0; i < mid; i++) {
				head = head.next;
			}
			return head;
		}
	}

	/**
	 * 快慢指针
	 */
	class Solution2 {
		public ListNode middleNode(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		ListNode(int x, ListNode next) {
			val = x;
			this.next = next;
		}
	}
}
