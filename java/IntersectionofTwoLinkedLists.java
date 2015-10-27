/*
 * Filename: IntersectionofTwoLinkedLists.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 18 Jun 2015 02:08:14 PM CST
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
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int lenA = length(headA);
		int lenB = length(headB);
		
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < lenB - lenA; i++) {
				headB = headB.next;
			}
		}

		ListNode head = new ListNode(0);
		ListNode p = head;

		while (headA != null) {
			if (headA.val == headB.val) {
				p.next = new ListNode(headA.val);
				p = p.next;
			} else {
				head.next = null;
				p = head;
			}
			
			headA = headA.next;
			headB = headB.next;
		}

		return head.next;
	}

	private int length(ListNode head) {
		int len = 0;

		while (head != null) {
			len++;
			head = head.next;
		}

		return len;
	}
}
