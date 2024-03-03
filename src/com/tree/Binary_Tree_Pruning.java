package com.tree;

public class Binary_Tree_Pruning {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(1);
		node.right = new TreeNode(0);

		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(1);

		node.left.left.left = new TreeNode(0);

		TreeNode result_BruteForce = pruneTree_BruteForce(node);
		System.out.println(result_BruteForce);

		TreeNode result_Optimal = pruneTree_Optimal(node);
		System.out.println(result_Optimal);

	}

	public static TreeNode pruneTree_BruteForce(TreeNode root) {

		return containsOne(root) ? root : null;
	}

	private static boolean containsOne(TreeNode root) {

		if (root == null)
			return false;

		// Check if any node in the left subtree contains a 1.
		boolean leftContainsOne = containsOne(root.left);

		// Check if any node in the right subtree contains a 1.
		boolean rightContainsOne = containsOne(root.right);

		// If the left subtree does not contain a 1, prune the subtree.
		if (!leftContainsOne)
			root.left = null;

		// If the right subtree does not contain a 1, prune the subtree.
		if (!rightContainsOne)
			root.right = null;

		// Return true if the current node, its left or right subtree contains a 1.
		return root.val == 1 || leftContainsOne || rightContainsOne;
	}

	// Post Order Traversal : Left Right Root
	public static TreeNode pruneTree_Optimal(TreeNode root) {
		if (root == null)
			return root;
		pruneTree_Optimal(root.left);
		pruneTree_Optimal(root.right);
		if (root.val == 0 && root.left == null && root.right == null) {
			return null;
		}
		return root;
	}

}
