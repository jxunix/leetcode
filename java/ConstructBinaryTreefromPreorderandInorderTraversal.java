/*
 * Filename: ConstructBinaryTreefromPreorderandInorderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 10:31:42 PM EDT
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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}

		if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}

		if (preorder.length == 1) {
			return new TreeNode(preorder[0]);
		}

		return buildTreeAux(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTreeAux(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
		if (s1 > e1) {
			return null;
		}

		if (s1 == e1) {
			return new TreeNode(preorder[s1]);
		}

		int i = s2;
		while (inorder[i] != preorder[s1]) {
			i++;
		}

		TreeNode root = new TreeNode(preorder[s1]);
		root.left = buildTreeAux(preorder, inorder, s1 + 1, s1 + i - s2, s2, i-1);
		root.right = buildTreeAux(preorder, inorder, s1 + i - s2 + 1, e1, i+1, e2);

		return root;
	}
}
