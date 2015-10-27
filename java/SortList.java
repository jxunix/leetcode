/*
 * Filename: SortList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 02:25:09 PM EDT
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
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		if (head.next.next == null) {
			if (head.val <= head.next.val) {
				return head;
			} else {
				ListNode tmp = head.next;
				head.next = null;
				tmp.next = head;
				return tmp;
			}
		}

		ListNode p1 = head;
		ListNode p2 = head;

		while (p1.next != null && p1.next.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
		}

		ListNode head2 = p2.next;
		p2.next = null;

		head = sortList(head);
		head2 = sortList(head2);
		return merge(head, head2);
	}

	private ListNode merge(ListNode head, ListNode head2) {
		ListNode hhead = new ListNode(0);
		ListNode p = hhead;

		while (head != null && head2 != null) {
			if (head.val <= head2.val) {
				ListNode tmp = head.next;
				p.next = head;
				p = p.next;
				p.next = null;
				head = tmp;
			} else {
				ListNode tmp = head2.next;
				p.next = head2;
				p = p.next;
				p.next = null;
				head2 = tmp;
			}
		}

		while (head != null) {
			ListNode tmp = head.next;
			p.next = head;
			p = p.next;
			p.next = null;
			head = tmp;
		}

		while (head2 != null) {
			ListNode tmp = head2.next;
			p.next = head2;
			p = p.next;
			p.next = null;
			head2 = tmp;
		}

		return hhead.next;
	}
}
