/*
 * Filename: CopyListwithRandomPointer.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 03 Jul 2015 08:45:56 AM EDT
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode head2 = new RandomListNode(head.label);
		RandomListNode p = head2;

		HashMap<RandomListNode, RandomListNode> map =
			new HashMap<RandomListNode, RandomListNode>();
		map.put(head, head2);

		while (head != null) {
			if (head.next != null) {
				if (map.containsKey(head.next)) {
					p.next = map.get(head.next);
				} else {
					p.next = new RandomListNode(head.next.label);
					map.put(head.next, p.next);
				}
			}

			if (head.random != null) {
				if (map.containsKey(head.random)) {
					p.random = map.get(head.random);
				} else {
					p.random = new RandomListNode(head.random.label);
					map.put(head.random, p.random);
				}
			}

			head = head.next;
			p = p.next;
		}

		return head2;
	}
}
