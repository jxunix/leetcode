/*
 * Filename: ValidateBinarySearchTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 09:22:39 AM EDT
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
	public boolean isValidBST(TreeNode root) {
		return inorderTraverse(root);
	}

	TreeNode prev = null;

	public boolean inorderTraverse(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (!inorderTraverse(root.left)) {
			return false;
		}

		if (prev != null) {
			if (root.val <= prev.val) {
				return false;
			}
		}

		prev = root;
		if (!inorderTraverse(root.right)) {
			return false;
		}

		return true;
	}
}
