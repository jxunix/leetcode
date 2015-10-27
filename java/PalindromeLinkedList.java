/*
 * Filename: PalindromeLinkedList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 12:32:07 PM EDT
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
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		if (head.next.next == null) {
			return head.val == head.next.val;
		}

		ListNode p = head;
		ListNode p2 = head;

		while (p.next != null && p.next.next != null) {
			p = p.next.next;
			p2 = p2.next;
		}

		ListNode head2 = p2.next;
		p2.next = null;
		head = reverse(head);

		if (p.next == null) {
			return equals(head.next, head2);
		} else {
			return equals(head, head2);
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode p = null;

		while (head != null) {
			ListNode tmp = head.next;
			head.next = p;
			p = head;
			head = tmp;
		}

		return p;
	}

	private boolean equals(ListNode head, ListNode head2) {
		while (head != null && head2 != null) {
			if (head.val != head2.val) {
				return false;
			}

			head = head.next;
			head2 = head2.next;
		}

		if (head != null || head2 != null) {
			return false;
		}

		return true;
	}
}
