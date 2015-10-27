/*
 * Filename: LinkedListCycleII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 05 Jul 2015 05:32:44 PM EDT
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;

		while (p1 != null && p1.next != null) {
			p1 = p1.next.next;
			p2 = p2.next;

			if (p1 == p2) {
				p1 = head;

				while (true) {
					if (p1 == p2) {
						return p1;
					}

					p1 = p1.next;
					p2 = p2.next;
				}
			}
		}

		return null;
	}
}
