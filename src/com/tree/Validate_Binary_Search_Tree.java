package com.tree;

public class Validate_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(5);

		node.left = new TreeNode(1);
		node.right = new TreeNode(8);

		node.right.left = new TreeNode(7);
		node.right.right = new TreeNode(9);

		boolean result = isValidBST(node);
		System.out.println(result);

	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return helperMethod(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean helperMethod(TreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;
		if (root.val >= maxValue || root.val <= minValue)
			return false;
		return helperMethod(root.left, minValue, root.val) && helperMethod(root.right, root.val, maxValue);
	}

}
