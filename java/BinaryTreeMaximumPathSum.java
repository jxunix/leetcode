/*
 * Filename: BinaryTreeMaximumPathSum.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 02:11:07 PM EDT
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
	public int maxPathSum(TreeNode root) {
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		maxPath(root, res);
		return res[0];
	}

	private int maxPath(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}

		int leftPath = maxPath(root.left, res);
		int rightPath = maxPath(root.right, res);
		int arch = leftPath + rightPath + root.val;
		int single = Math.max(root.val, Math.max(leftPath, rightPath) + root.val);
		res[0] = Math.max(res[0], Math.max(arch, single));
		return single;
	}
}
