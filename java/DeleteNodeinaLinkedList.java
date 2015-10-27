/*
 * Filename: DeleteNodeinaLinkedList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 14 Jul 2015 07:04:50 PM EDT
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
	public void deleteNode(ListNode node) {
		ListNode prev = new ListNode(0);
		prev.next = node;

		while (node != null && node.next != null) {
			node.val = node.next.val;
			node = node.next;
			prev = prev.next;
		}

		prev.next = null;
	}
}
