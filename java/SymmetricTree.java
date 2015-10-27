/*
 * Filename: SymmetricTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 12:41:12 PM EDT
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
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isSymmetricAux(root.left, root.right);
	}

	private boolean isSymmetricAux(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		}

		return left.val == right.val && isSymmetricAux(left.left, right.right) && isSymmetricAux(left.right, right.left);
	}
}
