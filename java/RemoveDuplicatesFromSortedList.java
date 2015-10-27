/*
 * Filename: RemoveDuplicatesFromSorted.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Mon 02 Mar 2015 08:17:13 PM EST
 */

/*
 * Definition for singly-linked list
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

		ListNode prev = head;
		ListNode curr = head.next;

		for (; curr != null; curr = curr.next) {
			if (curr.val == prev.val)
				prev.next = curr.next;
			else
				prev = prev.next;
		}

		return head;
	}
}
