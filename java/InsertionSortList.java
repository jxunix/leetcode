/*
 * Filename: InsertionSortList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 03:30:52 PM EDT
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
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			ListNode prev = dummy;

			while (prev.next != null && prev.next.val < curr.val) {
				prev = prev.next;
			}

			curr.next = prev.next;
			prev.next = curr;
			curr = next;
		}

		return dummy.next;
	}
}
