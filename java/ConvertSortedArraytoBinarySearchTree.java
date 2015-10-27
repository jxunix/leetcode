/*
 * Filename: ConvertSortedArraytoBinarySearchTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 02:25:14 PM EDT
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
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		return sortedArrayToBSTAux(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBSTAux(int[] nums, int stt, int end) {
		if (stt == end) {
			return new TreeNode(nums[stt]);
		}

		if (stt + 1 == end) {
			TreeNode node = new TreeNode(nums[end]);
			node.left = new TreeNode(nums[stt]);
			return node;
		}

		int mid = (stt + end) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBSTAux(nums, stt, mid - 1);
		node.right = sortedArrayToBSTAux(nums, mid + 1, end);
		return node;
	}
}
