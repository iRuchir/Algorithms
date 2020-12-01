package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	public BinaryTreeNode getSuccessor(BinaryTreeNode node) {
		BinaryTreeNode successor = null;
		if(node.right == null) {
			return node;
		}
		inOrderTraversalToFindSuccessor(node.right);
		return successor;
	}
	
	public void inOrderTraversalToFindSuccessor(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		inOrderTraversalToFindSuccessor(node.left);
		System.out.println(node);
		return;
		//inOrderTraversalToFindSuccessor(node.right);
	}

	public static boolean isBinarySearchTree(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		System.out.println(root);
		if ((root.left != null && Integer.parseInt(root.left.name) > Integer.parseInt(root.name))
				|| (root.right != null && Integer.parseInt(root.name) > Integer.parseInt(root.right.name))
				|| (root.left != null && root.right != null
						&& Integer.parseInt(root.left.name) > Integer.parseInt(root.right.name))) {
			System.out.println("At node" + " -> " + root);
			return false;
		}
		return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
	}

	public BinaryTreeNode createBinarySerachTree(int[] elements) {

		List<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();

		for (int i : elements) {
			nodes.add(new BinaryTreeNode(String.valueOf(i)));
		}

		int middle = nodes.size() / 2;

		BinaryTreeNode middleNode = nodes.get(middle);
		createBinarySerachTree(nodes);
		TreeTraversal.inOrderTraversal(middleNode);
		System.out.println();
		TreeTraversal.preOrderTraversal(middleNode);
		return null;
	}

	public BinaryTreeNode createBinarySerachTree(List<BinaryTreeNode> nodes) {
		if (nodes == null || nodes.size() == 0) {
			return null;
		} else if (nodes.size() == 1) {
			return nodes.get(0);
		}
		int middle = nodes.size() / 2;
		BinaryTreeNode middleNode = nodes.get(middle);
		middleNode.left = (createBinarySerachTree(nodes.subList(0, middle)));
		middleNode.right = (createBinarySerachTree(nodes.subList(middle + 1, nodes.size())));
		return middleNode;
	}

}
