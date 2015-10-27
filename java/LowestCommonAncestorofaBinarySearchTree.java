/*
 * Filename: LowestCommonAncestorofaBinarySearchTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 01:38:06 PM EDT
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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return null;
		}

		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);

		while (root != null) {
			if (min <= root.val && root.val <= max) {
				return root;
			} else if (root.val < min) {
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return root;
	}
}
