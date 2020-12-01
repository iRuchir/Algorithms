package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

	public ArrayList<LinkedList<BinaryTreeNode>> createLevelLinkedList(BinaryTreeNode root) {
		ArrayList<LinkedList<BinaryTreeNode>> lists = new ArrayList<LinkedList<BinaryTreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	private void createLevelLinkedList(BinaryTreeNode node, ArrayList<LinkedList<BinaryTreeNode>> lists, int level) {
		if(node == null) {
			return;
		}
		LinkedList<BinaryTreeNode> list = null;
		
		if(lists.size() == level) {
			list = new LinkedList<BinaryTreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(node);
		createLevelLinkedList(node.left, lists, level+1);
		createLevelLinkedList(node.right, lists, level+1);
	}

}
