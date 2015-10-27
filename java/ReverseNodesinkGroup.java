/*
 * Filename: ReverseNodesinkGroup.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 12:59:49 PM EDT
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode rear;
		ListNode rrear = dummy;

		ListNode prev;
		ListNode curr = head;
		ListNode next;
		int i = 0;

		for (; head != null; head = head.next, i++) {
			if (i == 0 || i % k != 0) {
				continue;
			}

			rear = curr;
			prev = null;
			while (curr != head) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}

			rrear.next = prev;
			rrear = rear;
		}

		if (i % k == 0) {
			prev = null;
			while (curr != head) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			
			rrear.next = prev;
		} else {
			rrear.next = curr;
		}

		return dummy.next;
	}
}
