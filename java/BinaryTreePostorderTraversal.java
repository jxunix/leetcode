/*
 * Filename: BinaryTreePostorderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 05 Jul 2015 08:57:32 PM EDT
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
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();

			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					res.add(curr.val);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					res.add(curr.val);
				}
			} else if (curr.right == prev) {
				stack.pop();
				res.add(curr.val);
			}

			prev = curr;
		}

		return res;
	}
}
