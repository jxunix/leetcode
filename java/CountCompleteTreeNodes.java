/*
 * Filename: CountCompleteTreeNodes.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 01:55:06 PM EDT
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
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = getLeft(root);
		int r = getRight(root);

		if (l == r) {
			return (2 << (l-1)) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private int getLeft(TreeNode root) {
		int count = 1;

		while (root.left != null) {
			root = root.left;
			count++;
		}

		return count;
	}

	private int getRight(TreeNode root) {
		int count = 1;

		while (root.right != null) {
			root = root.right;
			count++;
		}

		return count;
	}
}
