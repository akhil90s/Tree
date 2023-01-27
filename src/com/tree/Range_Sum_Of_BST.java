package com.tree;

import java.util.Stack;

public class Range_Sum_Of_BST {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(15);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(7);
		treeNode.right.right = new TreeNode(18);

		int result_Iterative = rangeSumBST_Iterative(treeNode, 7, 15);
		System.out.println(result_Iterative);
		
		int result_Recursive = rangeSumBST_Recursive(treeNode, 7, 15);
		System.out.println(result_Recursive);

	}

	private static int rangeSumBST_Recursive = 0;
	
	public static int rangeSumBST_Recursive(TreeNode root, int low, int high) {
		helperMethod_Recursive(root, low, high);
		return rangeSumBST_Recursive;
	}
	
	public static int helperMethod_Recursive(TreeNode root, int low, int high) {
		if(root!=null) {
			if(root.value >=low && root.value <=high) {
				rangeSumBST_Recursive +=root.value;
			}
			if(root.value >low) {
				helperMethod_Recursive(root.left,low,high);
			}
			if(root.value <high) {
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
				if (node.value >= low && node.value <= high) {
					rangeSumBST += node.value;
				}
				if (node.value > low) {
					stack.push(node.left);
				}
				if (node.value < high) {
					stack.push(node.right);
				}
			}
		}
		return rangeSumBST;
	}

}
