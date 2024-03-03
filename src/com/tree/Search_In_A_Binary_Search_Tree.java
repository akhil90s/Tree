package com.tree;

public class Search_In_A_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(4);

		node.left = new TreeNode(2);
		node.right = new TreeNode(7);

		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);

		TreeNode result_Recursion = searchBST_Recursion(node, 2);
		System.out.println(result_Recursion.val);

	}

	public static TreeNode searchBST_Recursion(TreeNode root, int val) {
		if (root == null)
			return null;
		if(root.val == val)
			return root;
		if(root.val > val)
			return searchBST_Recursion(root.left, val);
		if(root.val < val)
			return searchBST_Recursion(root.right, val);
		return null;
	}

}
