package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_Of_Binary_Tree {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(3);
		node.right.right = new TreeNode(8);
		
		node.left.left.right = new TreeNode(4);
		node.right.right.left = new TreeNode(9);
		
		node.left.left.right.left = new TreeNode(5);
		node.left.left.right.right = new TreeNode(6);
		node.right.right.left.left = new TreeNode(10);
		node.right.right.left.right = new TreeNode(11);
		
		List<Integer> result = boundaryLevelTraversal(node);
		System.out.println(result);
		
	}
	
	public static List<Integer> boundaryLevelTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		return null;
	}


}
