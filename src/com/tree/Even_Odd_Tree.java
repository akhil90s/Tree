package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Even_Odd_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(10);
		node.right = new TreeNode(4);

		node.left.left = new TreeNode(3);
		node.right.left = new TreeNode(7);
		node.right.right = new TreeNode(9);

		node.left.left.left = new TreeNode(12);
		node.left.left.right = new TreeNode(8);
		node.right.left.left = new TreeNode(6);
		node.right.right.right = new TreeNode(2);

		boolean result = isEvenOddTree(node);
		System.out.println(result);

	}

	public static boolean isEvenOddTree(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int n = queue.size();
			int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				if (level % 2 == 0) {
					if (node.val % 2 == 0 || node.val <= prev) {
						return false;
					}
				} else {
					if (node.val % 2 != 0 || node.val >= prev) {
						return false;
					}
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				prev = node.val;
			}
			level += 1;
		}
		return true;
	}

}
