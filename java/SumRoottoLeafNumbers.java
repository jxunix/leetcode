/*
 * Filename: SumRoottoLeafNumbers.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 01 Jul 2015 12:11:53 PM EDT
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
	public int sumNumbers(TreeNode root) {
		int res = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode p = stack.pop();

			if (p == null) {
				continue;
			}

			if (p.left == null && p.right == null) {
				res += p.val;
			}

			if (p.left != null) {
				p.left.val += p.val * 10;
			}

			if (p.right != null) {
				p.right.val += p.val * 10;
			}

			stack.push(p.left);
			stack.push(p.right);
		}

		return res;
	}
}
