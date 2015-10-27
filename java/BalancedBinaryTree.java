/*
 * Filename: BalancedBinaryTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 01:53:41 PM EDT
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
	public boolean isBalanced(TreeNode root) {
		return isBalancedAux(root) != -1;
	}

	public int isBalancedAux(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lHeight = isBalancedAux(root.left);
		if (lHeight == -1) {
			return -1;
		}

		int rHeight = isBalancedAux(root.right);
		if (rHeight == -1) {
			return -1;
		}

		if (Math.abs(lHeight - rHeight) > 1) {
			return -1;
		}

		return Math.max(lHeight, rHeight) + 1;
	}
}
