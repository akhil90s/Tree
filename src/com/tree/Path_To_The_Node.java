package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Path_To_The_Node {

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

		List<Integer> path = new ArrayList<>();
		getPathToNode(node, path, 7);
		System.out.println(path);

	}

	public static boolean getPathToNode(TreeNode root, List<Integer> path, int val) {
		if (root == null) {
			return false;
		}
		path.add(root.val);
		if (root.val == val) {
			return true;
		}
		if (getPathToNode(root.left, path, val) || getPathToNode(root.right, path, val)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

}
