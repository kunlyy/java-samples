package crk.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/submissions/
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * Created by chenrongkun on 2019/5/6.
 */
public class No203 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(4, null)))));
		head = Solution.removeElements(head, 1);
		System.out.println(head.val);
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	static class Solution {
		public static ListNode removeElements(ListNode head, int val) {
			ListNode tempHead = new ListNode(-1);
			tempHead.next = head;
			ListNode cur = tempHead;
			while (cur.next != null) {
				if (cur.next.val == val) {
					cur.next = cur.next.next;
				} else {
					cur = cur.next;
				}
			}
			return tempHead.next;
		}
	}

	static class ListNode {
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
