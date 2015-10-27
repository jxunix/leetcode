/*
 * Filename: BinaryTreeLevelOrderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 12:46:19 PM EDT
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		List<Integer> vals;
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<TreeNode> nodesCpy;

		nodes.add(root);
		while (!nodes.isEmpty()) {
			vals = new ArrayList<Integer>();
			nodesCpy = new ArrayList<TreeNode>();
			
			for (TreeNode node: nodes) {
				if (node != null) {
					vals.add(node.val);
					nodesCpy.add(node.left);
					nodesCpy.add(node.right);
				}
			}

			nodes = nodesCpy;
			if (!vals.isEmpty()) {
				res.add(vals);
			}
		}

		return res;
	}
}
