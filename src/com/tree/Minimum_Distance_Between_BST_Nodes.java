package com.tree;

public class Minimum_Distance_Between_BST_Nodes {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		int result_Recursion = minDiffInBST_Recursion(root);
		System.out.println(result_Recursion);

	}

	private static int minDiffInBST = Integer.MAX_VALUE;
	private static TreeNode prev = null;

	public static int minDiffInBST_Recursion(TreeNode root) {
		if (root == null)
			return minDiffInBST;
		inorderTraversal(root);
		return minDiffInBST;
	}

	private static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		if (prev != null) {
			minDiffInBST = Math.min(minDiffInBST, Math.abs(root.val - prev.val));
		}
		prev = root;
		inorderTraversal(root.right);
	}

}
