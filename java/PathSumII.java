/*
 * Filename: PathSumII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 08:13:41 AM CST
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		List<Integer> path = new ArrayList<Integer>();
		pathSumAux(root, sum, path, res);
		return res;
	}

	private void pathSumAux(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null && root.val == sum) {
			path.add(root.val);
			res.add(path);
			return;
		}

		path.add(root.val);
		pathSumAux(root.left, sum - root.val, new ArrayList<Integer>(path), res);
		pathSumAux(root.right, sum - root.val, new ArrayList<Integer>(path), res);
	}
}
