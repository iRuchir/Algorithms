package com.ruchir.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

	Stack<GraphNode> stack;
	Queue<GraphNode> queue;

	public GraphSearch() {
		stack = new Stack<GraphNode>();
		queue = new LinkedList<GraphNode>();
	}

	public void depthFirstSearch(GraphNode root) {

		// Base Case
		if (root.children == null) {
			System.out.println(root.name);
			return;
		}

		stack.push(root);
		System.out.println(root.name);
		root.isVisited = true;

		for (GraphNode child : root.children) {
			if (!child.isVisited) {
				depthFirstSearch(child);
				stack.pop();
			}
		}
	}

	public void breadthFirstSearch(GraphNode root) {

		// Base cases
		if (root == null) {
			return;
		}

		GraphNode node;
		queue.add(root);

		while (!queue.isEmpty()) {
			node = queue.poll();
			if(!node.isVisited) {
				System.out.println(node.name);
				node.isVisited = true;
			}
			for (GraphNode child : node.children) {
				if (!child.isVisited) {
					queue.add(child);
				}
			}
		}

	}
}
