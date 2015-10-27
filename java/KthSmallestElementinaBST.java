/*
 * Filename: KthSmallestElementinaBST.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 03:59:38 PM EDT
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
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.isEmpty() || root != null) {
			if (root == null) {
				root = stack.pop();

				if (--k == 0) {
					return root.val;
				}

				root = root.right;
			} else {
				stack.push(root);
				root = root.left;
			}
		}

		return 0;
	}
}
