package com.tree;

import java.util.Stack;

public class Range_Sum_Of_BST {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(15);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(7);
		node.right.right = new TreeNode(18);

		int result_Iterative = rangeSumBST_Iterative(node, 7, 15);
		System.out.println(result_Iterative);
		
		int result_Recursive = rangeSumBST_Recursive(node, 7, 15);
		System.out.println(result_Recursive);

	}

	private static int rangeSumBST_Recursive = 0;
	
	public static int rangeSumBST_Recursive(TreeNode root, int low, int high) {
		helperMethod_Recursive(root, low, high);
		return rangeSumBST_Recursive;
	}
	
	public static int helperMethod_Recursive(TreeNode root, int low, int high) {
		if(root!=null) {
			if(root.val >=low && root.val <=high) {
				rangeSumBST_Recursive +=root.val;
			}
			if(root.val >low) {
				helperMethod_Recursive(root.left,low,high);
			}
			if(root.val <high) {
				helperMethod_Recursive(root.right,low,high);
			}
		}
		return rangeSumBST_Recursive;
	}
	
	
	public static int rangeSumBST_Iterative(TreeNode root, int low, int high) {
		int rangeSumBST = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				if (node.val >= low && node.val <= high) {
					rangeSumBST += node.val;
				}
				if (node.val > low) {
					stack.push(node.left);
				}
				if (node.val < high) {
					stack.push(node.right);
				}
			}
		}
		return rangeSumBST;
	}

}
