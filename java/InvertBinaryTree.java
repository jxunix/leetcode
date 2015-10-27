/*
 * Filename: InvertBinaryTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 16 Jun 2015 03:07:06 PM CST
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
    public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			}

			if (root.left == null && root.right == null) {
				return root;
			} else if (root.left == null) {
				root.left = invertTree(root.right);
				root.right = null;
				return root;
			} else if (root.right == null) {
				root.right = invertTree(root.left);
				root.left = null;
				return root;
			} else {
				TreeNode tmp = root.left;
				root.left = invertTree(root.right);
				root.right = invertTree(tmp);
				return root;
			}
    }
}
