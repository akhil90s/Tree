package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(5);

		List<String> result_Recursive = binaryTreePaths_Recursive(root);
		System.out.println(result_Recursive);

	}

	public static List<String> binaryTreePaths_Recursive(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;
		helperMethod_Recursive(root, result, "");
		return result;
	}

	private static void helperMethod_Recursive(TreeNode root, List<String> result, String s) {
		s += root.val + "->";
		if (root.left == null && root.right == null) {
			result.add(s.substring(0, s.length() - 2));
			return;
		}
		if (root.left != null)
			helperMethod_Recursive(root.left, result, s);
		if (root.right != null)
			helperMethod_Recursive(root.right, result, s);
	}

}
