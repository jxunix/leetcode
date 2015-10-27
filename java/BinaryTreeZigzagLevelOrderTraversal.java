/*
 * Filename: BinaryTreeZigzagLevelOrderTraversal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 01:10:10 PM EDT
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		int level = 1;
		List<Integer> vals;
		Stack nodes = new Stack();
		Stack nodesCpy;

		nodes.push(root);
		while (!nodes.isEmpty()) {
			vals = new ArrayList<Integer>();
			nodesCpy = new Stack();
			
			while (!nodes.empty()) {
				TreeNode node = (TreeNode) nodes.pop();

				if (node != null) {
					vals.add(node.val);
					if (level % 2 == 0) {
						nodesCpy.push(node.right);
						nodesCpy.push(node.left);
					} else {
						nodesCpy.push(node.left);
						nodesCpy.push(node.right);
					}
				}
			}

			level++;
			nodes = nodesCpy;
			if (!vals.isEmpty()) {
				res.add(vals);
			}
		}

		return res;
	}
}
