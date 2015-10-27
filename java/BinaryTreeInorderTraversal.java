/*
 * Filename: BinaryTreeInorderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 29 May 2015 09:30:01 AM EDT
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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (roor == null) {
			return res;
		}

		inorderTraversalAux(root, res);
		return res;
	}

	private void inorderTraversalAux(TreeNode root, List<Integer> res) {
		if (root == null) {
			inorderTraversalAux(root.left, res);
			res.add(root.val);
			inorderTraversalAux(root.left, res);
		}

		return;
	}
}
