/*
 * Filename: SwapNodesinPairs.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 12:15:29 PM EDT
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
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;
		ListNode temp;

		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = prev.next;

			temp = curr;
			curr.next = prev.next;
			curr = curr.next;

			prev.next = temp;
			prev = prev.next;
		}

		return dummy.next;
	}
}
