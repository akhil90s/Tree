package com.tree;

public class Maximum_Depth_Of_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(3);

		node.left = new TreeNode(9);
		node.right = new TreeNode(20);

		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);

		int result = maxDepth(node);
		System.out.println(result);

	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

}
