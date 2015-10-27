/*
 * Filename: RemoveDuplicatesFromSortedListII.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Mon 02 Mar 2015 08:31:29 PM EST
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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode curr = head.next;
		ListNode prev = head;
		ListNode pprev = dummy;

		for (; curr != null; curr = curr.next, prev = prev.next) {
			if (curr.val == prev.val)
				pprev.next = curr.next;
			else {
				if (prev.next != pprev.next)
				    pprev = prev;
			}
		}
		
		return dummy.next;
	}
}
