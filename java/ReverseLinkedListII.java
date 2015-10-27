/*
 * Filename: ReverseLinkedListII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 28 May 2015 02:10:27 PM EDT
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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}

		if (m == n) {
			return head;
		}

		ListNode p = new ListNode(0);
		p.next = head;
		head = p;
		ListNode tail = p;

		ListNode head2 = null;
		ListNode tail2 = null;
		int i = 1;

		while (p != null) {
			if (i == m) {
				tail = p;
				p = p.next;
			} else if (i == m+1) {
				ListNode tmp = p.next;
				p.next = head2;
				head2 = p;
				tail2 = p;
				p = tmp;
			} else if (i > m+1 && i <= n) {
				ListNode tmp = p.next;
				p.next = head2;
				head2 = p;
				p = tmp;
			} else if (i == n+1) {
				ListNode tmp = p.next;
				p.next = head2;
				head2 = p;
				p = tmp;
				tail.next = head2;
				tail2.next = p;
				break;
			} else {
				p = p.next;
			}

			i++;
		}

		return head.next;
	}
}
