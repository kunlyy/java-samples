package crk.algorithm.leetcode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * Created by chenrongkun on 2019/5/7.
 */
public class No206 {

	public static void main(String[] args) {
		ListNode head = new No206().new ListNode(1, new No206().new ListNode(2, new No206().new ListNode(3, new No206().new ListNode(6, new No206().new ListNode(4, null)))));
		head = new No206().new Solution().reverseList(head);
		System.out.println(head.val);
	}

	class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode pre = null;
			ListNode cur = head;
			while (cur != null) {
				ListNode curNext = cur.next;
				cur.next = pre;
				pre = cur;
				cur = curNext;
			}
			return pre;
		}
	}

	/**
	 * TODO：递归解法
	 *
	 */
	class Solution2 {
		public ListNode reverseList(ListNode head) {
			return null;
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
