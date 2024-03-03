package com.tree;

public class Recover_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(3);

		node.left = new TreeNode(1);
		node.right = new TreeNode(4);

		node.left.left = new TreeNode(2);

		inorderTraversal(node);
		recoverTree(node);
		System.out.println();
		inorderTraversal(node);

	}

	private static TreeNode first;
	private static TreeNode middle;
	private static TreeNode last;
	private static TreeNode prev;

	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;
		first = middle = last = null;
		prev = new TreeNode(Integer.MIN_VALUE);
		helperMethod_recoverTree(root);
		if (first != null && last != null) {
			int temp = first.val;
			first.val = last.val;
			last.val = temp;
		}
		if (first != null && middle != null) {
			int temp = first.val;
			first.val = middle.val;
			middle.val = temp;
		}
		return;
	}

	private static void helperMethod_recoverTree(TreeNode root) {
		if (root == null)
			return;
		helperMethod_recoverTree(root.left);
		if (prev != null && (root.val < prev.val)) {
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		}
		prev = root;
		helperMethod_recoverTree(root.right);
	}

	public static void inorderTraversal(TreeNode root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

}
