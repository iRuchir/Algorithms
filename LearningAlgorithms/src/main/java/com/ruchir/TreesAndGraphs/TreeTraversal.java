package com.ruchir.TreesAndGraphs;

public class TreeTraversal {
	public static void inOrderTraversal(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.name + " > ");
		inOrderTraversal(root.right);
	}

	public static void preOrderTraversal(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.name + " > ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void postOrderTraversal(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.name + " > ");
	}
}
