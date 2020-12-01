package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class FirstCommonAncestor {
	public BinaryTreeNode findCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		
		/*
		 * 1. Get path to root for each node.
		 * 2. store in list.
		 * 3. Find first common element in list, it will be first common ancestor.
		 */
		List<BinaryTreeNode> pathToRootNode1 = new ArrayList<BinaryTreeNode>();
		List<BinaryTreeNode> pathToRootNode2 = new ArrayList<BinaryTreeNode>();
		
		BinaryTreeNode current = node1;
		while(!current.name.equals(root.name)) {
			pathToRootNode1.add(current);
			current = current.parent;
		}
		
		current = node2;
		while(!current.name.equals(root.name)) {
			pathToRootNode2.add(current);
			current = current.parent;
		}
		
		System.out.println(pathToRootNode1);
		System.out.println(pathToRootNode2);
		
		for (BinaryTreeNode binaryTreeNode : pathToRootNode2) {
			if(pathToRootNode1.contains(binaryTreeNode)) {
				return binaryTreeNode;
			}
		}
		
		return null;
	}
}
