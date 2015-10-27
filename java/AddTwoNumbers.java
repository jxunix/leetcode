/*
 * Filename: AddTwoNumbers.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Tue 03 Mar 2015 12:40:21 AM EST
 */

/**
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int sum;

		ListNode p1, p2;
		ListNode head = new ListNode(0);
		ListNode prev = head;
		ListNode curr;

		for (p1 = l1, p2 = l2; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
			sum = p1.val + p2.val + carry;
			carry = sum / 10;
			curr = new ListNode(sum % 10);
			prev.next = curr;
			prev = prev.next;
		}

		if (p1 == null) p1 = p2;

		for (; p1 != null; p1 = p1.next) {
			sum = p1.val + carry;
			carry = sum / 10;
			curr = new ListNode(sum % 10);
			prev.next = curr;
			prev = prev.next;
		}

		if (carry == 1) {
			curr = new ListNode(carry);
			prev.next= curr;
		}

		return head.next;
	}
}
