/*
 * Filename: MinimumDepthofBinaryTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 02:01:47 PM EDT
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
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return minDepthAux(root);
	}

	private int minDepthAux(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}

		int res = Integer.MAX_VALUE;
		
		if (root.left != null) {
			res = Math.min(res, minDepthAux(root.left));
		}

		if (root.right != null) {
			res = Math.min(res, minDepthAux(root.right));
		}

		return res+1;
	}
}
