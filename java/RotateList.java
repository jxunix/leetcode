/*
 * Filename: RotateList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 04:58:58 PM EDT
 */

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		if (k == 0) {
			return head;
		}

		ListNode curr = head;
		ListNode tail = new ListNode(0);
		int size = 0;

		while (curr != null) {
			curr = curr.next;
			size++;
			if (curr != null && curr.next == null) {
				tail = curr;
			}
		}

		k = k % size;
		if (k == 0) {
			return head;
		}

		curr = head;
		for (int i = 1; i < size - k; i++) {
			curr = curr.next;
		}

		tail.next = head;
		head = curr.next;
		curr.next = null;

		return head;
	}
}
