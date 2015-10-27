/*
 * Filename: WordBreak.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 03 Jul 2015 09:58:52 AM EDT
 */

public class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		ListNode p1 = head;
		ListNode p2 = head;

		while (p1.next != null && p1.next.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;
		}

		ListNode head2 = p2.next;
		p2.next = null;
		head2 = reverse(head2);
		merge(head, head2);
	}

	private ListNode reverse(ListNode head) {
		ListNode tail = null;
		ListNode tmp = head;

		while (tmp != null) {
			head = tmp;
			tmp = tmp.next;
			head.next = tail;
			tail = head;
		}

		return head;
	}

	private void merge(ListNode head, ListNode head2) {
		ListNode tmp;

		while (head2 != null) {
			tmp = head2.next;
			head2.next = head.next;
			head.next = head2;
			head = head.next.next;
			head2 = tmp;
		}
	}
}
