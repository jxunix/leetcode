/*
 * Filename: FlattenBinaryTreetoLinkedList.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 27 Jun 2015 01:19:26 PM EDT
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
	TreeNode prev;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		prev = null;
		flattenAux(root);
	}

	private void flattenAux(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		if (prev != null) {
			prev.right = root;
		}
		prev = root;
		root.left = null;
		root.right = null;

		flattenAux(left);
		flattenAux(right);
	}
}
