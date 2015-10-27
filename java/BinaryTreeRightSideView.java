/*
 * Filename: BinaryTreeRightSideView.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 06:00:26 PM EDT
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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = null;
		queue.add(root);

		while (!queue.isEmpty()) {
			queue2 = new LinkedList<TreeNode>();

			while (!queue.isEmpty()) {
				TreeNode p = queue.poll();

				if (queue.isEmpty()) {
					res.add(p.val);
				}

				if (p.left != null) {
					queue2.add(p.left);
				}

				if (p.right != null) {
					queue2.add(p.right);
				}
			}

			queue = queue2;
		}

		return res;
	}
}
