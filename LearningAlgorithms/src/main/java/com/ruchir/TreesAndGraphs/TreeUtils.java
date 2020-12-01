package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

	public static BinaryTreeNode createBinaryTree(List<List<BinaryTreeNode>> listOfNodes) {

		BinaryTreeNode root = listOfNodes.get(0).get(0);
		BinaryTreeNode current = root;

		listOfNodes.remove(0);

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);

		for (List<BinaryTreeNode> pair : listOfNodes) {
			System.out.println(queue+"->"+pair);
			current = queue.poll();
			//System.out.println(pair);
			if (current != null && pair.size() > 1)
				createNodeFamily(current, pair);
			queue.offer(pair.get(0));
			queue.offer(pair.get(1));
		}

		TreeTraversal.inOrderTraversal(root);
		System.out.println();
		TreeTraversal.preOrderTraversal(root);
		return root;

	}

	public static List<List<BinaryTreeNode>> stringToListOfNodes(String input) {
		// input sample -> 1,2;3,4;5,6;7,null;9,10;null,12;

		List<List<BinaryTreeNode>> listOfNodes = new ArrayList<List<BinaryTreeNode>>();

		String[] pairs = input.split(";");

		String[] nodes = null;
		List<BinaryTreeNode> list;

		for (String pair : pairs) {
			list = new ArrayList<BinaryTreeNode>();
			nodes = pair.split(",");

			list.add((!nodes[0].equals("NULL")) ? new BinaryTreeNode(nodes[0]) : null);
			if (nodes.length == 2)
				list.add((!nodes[1].equals("NULL")) ? new BinaryTreeNode(nodes[1]) : null);
//				list.add(new BinaryTreeNode(nodes[1]));
			listOfNodes.add(list);
		}
		System.out.println(listOfNodes);
		return listOfNodes;
	}

	public static void createNodeFamily(BinaryTreeNode p, List<BinaryTreeNode> c) {
		p.left = c.get(0);
		p.right = c.get(1);
		if (c.get(0) != null)
			c.get(0).parent = p;
		if (c.get(1) != null)
			c.get(1).parent = p;
	}

}
