/*
 * Filename: ConstructBinaryTreefromInorderandPostorderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 01 Jun 2015 10:13:25 AM EDT
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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}

		if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
			return null;
		}

		if (inorder.length == 1) {
			return new TreeNode(inorder[0]);
		}

		return buildTreeAux(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	private TreeNode buildTreeAux(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
		if (s1 > e1) {
			return null;
		}

		if (s1 == e1) {
			return new TreeNode(inorder[s1]);
		}

		int i = s1;
		while (inorder[i] != postorder[e2]) {
			i++;
		}

		TreeNode root = new TreeNode(postorder[e2]);
		root.left = buildTreeAux(inorder, postorder, s1, i-1, s2, s2 + i - s1 - 1);
		root.right = buildTreeAux(inorder, postorder, i+1, e1, s2 + i - s1, e2 - 1);

		return root;
	}
}
