/*
 * Filename: RemoveNthNodeFromEndofList.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Thu 12 Mar 2015 05:15:32 PM EDT
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode prev = null;
		ListNode curr = head;
		int i = 0;

		for (; curr != null; curr = curr.next, i++) {
			if (i == n) {
				prev = head;
			} else if (i > n) {
				prev = prev.next;
			}
		}

		if (i == n) {
			prev.next = prev.next.next;
		} else {
			head = head.next;
		}

		return head;
	}
}
