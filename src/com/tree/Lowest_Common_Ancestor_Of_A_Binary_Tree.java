package com.tree;

public class Lowest_Common_Ancestor_Of_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(3);

		node.left = new TreeNode(5);
		node.right = new TreeNode(1);

		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);

		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);

		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);

		TreeNode result = lowestCommonAncestor(node, node.left, node.right.right);
		System.out.println(result.val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}
	}


}
