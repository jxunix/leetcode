/*
 * Filename: PopulatingNextRightPointersinEachNode.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 28 Jun 2015 12:05:26 PM EDT
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		TreeLinkNode p = root;

		while (p.left != null) {
			TreeLinkNode q = p;

			while (q.next != null) {
				q.left.next = q.right;
				q.right.next = q.next.left;
				q = q.next;
			}

			q.left.next = q.right;
			p = p.left;
		}
	}
}
