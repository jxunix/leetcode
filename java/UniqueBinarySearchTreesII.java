/*
 * Filename: UniqueBinarySearchTreesII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 29 May 2015 01:48:37 PM EDT
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
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();

		if (left > right) {
			res.add(null);
			return res;
		}

		for (int i = left; i <= right; i++) {
			List<TreeNode> lTrees = generateTrees(left, i-1);
			List<TreeNode> rTrees = generateTrees(i+1, right);

			for (TreeNode lTree: lTrees) {
				for (TreeNode rTree: rTrees) {
					TreeNode root = new TreeNode(i);
					root.left = lTree;
					root.right = rTree;
					res.add(root);
				}
			}
		}

		return res;
	}
}
