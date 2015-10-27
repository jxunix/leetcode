/*
 * Filename: ReverseLinkedList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 12:30:27 PM CST
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode head2 = null;
		ListNode p;
		while (head != null) {
			p = new ListNode(head.val);
			p.next = head2;
			head2 = p;
			head = head.next;
		}

		return head2;
	}
}
