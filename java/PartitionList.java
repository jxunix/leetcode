/*
 * Filename: PartitionList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 26 May 2015 02:55:56 PM EDT
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
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		
		ListNode p1 = new ListNode(0);
		p1.next = head;
		head = p1;
		ListNode head2 = new ListNode(0);
		ListNode p2 = head2;

		while (p1.next != null) {
			if (p1.next.val >= x) {
				p2.next = p1.next;
				p1.next = p1.next.next;
				p2 = p2.next;
			} else {
				p1 = p1.next;
			}
		}

		p1.next = head2.next;
		p2.next = null;
		return head.next;
	}
}
