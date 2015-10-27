/*
 * Filename: ConvertSortedListtoBinarySearchTree.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 30 May 2015 08:20:29 PM EDT
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new TreeNode(head.val);
		}

		List<TreeNode> nodes = new ArrayList<TreeNode>();
		int size = 0;
		while (head != null) {
			nodes.add(new TreeNode(head.val));
			head = head.next;
			size++;
		}

		return sortedListToBSTAux(nodes, 0, size - 1);
	}

	private TreeNode sortedListToBSTAux(List<TreeNode> nodes, int stt, int end) {
		if (stt == end) {
			return nodes.get(stt);
		}

		if (stt + 1 == end) {
			TreeNode root = nodes.get(end);
			root.left = nodes.get(stt);
			return root;
		}

		int mid = (stt + end) / 2;
		TreeNode root = nodes.get(mid);
		root.left = sortedListToBSTAux(nodes, stt, mid - 1);
		root.right = sortedListToBSTAux(nodes, mid + 1, end);
		return root;
	}
}
