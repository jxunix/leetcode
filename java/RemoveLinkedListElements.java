/*
 * Filename: RemoveLinkedListElements.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 05 Jun 2015 06:38:57 AM CST
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
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode p = new ListNode(0);
		p.next = head;
		ListNode head2 = p;

		while (p.next != null) {
			if (p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}

		return head2.next;
	}
}
