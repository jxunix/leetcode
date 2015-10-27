/*
 * Filename: TreeNode.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 29 May 2015 02:16:23 PM EDT
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

	public static void inorderPrint(TreeNode root) {
		inorderPrintAux(root);
		System.out.println();
	}

	private static void inorderPrintAux(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderPrintAux(root.left);
		System.out.print(root.val + " ");
		inorderPrintAux(root.right);
	}

	public static void preorderPrint(TreeNode root) {
		preorderPrintAux(root);
		System.out.println();
	}

	private static void preorderPrintAux(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preorderPrintAux(root.left);
		preorderPrintAux(root.right);
	}

	public static void postorderPrint(TreeNode root) {
		postorderPrintAux(root);
		System.out.println();
	}

	private static void postorderPrintAux(TreeNode root) {
		if (root == null) {
			return;
		}

		postorderPrintAux(root.left);
		postorderPrintAux(root.right);
		System.out.print(root.val + " ");
	}

	public static void levelorderPrint(TreeNode root) {
		levelorderPrintAux(root);
		System.out.println();
	}

	private static void levelorderPrintAux(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = null;
		queue.add(root);

		while (!queue.isEmpty()) {
			for (TreeNode node: queue) {
				if (node != null) {
					System.out.print(node.val + " ");
				} else {
					System.out.print("# ");
				}
			}
			System.out.println();

			queue2 = new LinkedList<TreeNode>();
			while (!queue.isEmpty()) {
				TreeNode tmp = queue.poll();

				if (tmp != null) {
					queue2.add(tmp.left);
					queue2.add(tmp.right);
				}
			}

			queue = queue2;
		}
	}
}
