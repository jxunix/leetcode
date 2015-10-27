/*
 * Filename: RecoverBinarySearchTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 25 Jun 2015 03:27:59 PM EDT
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	TreeNode p1;
	TreeNode p2;
	TreeNode prev;

	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		p1 = null;
		p2 = null;
		prev = null;

		inorder(root);

		if (p1 != null && p2 != null) {
			int tmp = p1.val;
			p1.val = p2.val;
			p2.val = tmp;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);

		if (prev != null) {
			if (prev.val > root.val) {
				if (p1 == null) {
					p1 = prev;
				}

				p2 = root;
			}
		}

		prev = root;
		inorder(root.right);
	}
}
