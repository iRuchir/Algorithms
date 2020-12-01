package com.ruchir.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUtils {
	
	static Stack<GraphNode> stack = new Stack<GraphNode>();;
	static Queue<GraphNode> queue = new LinkedList<GraphNode>();;

	public static void depthFirstSearch(GraphNode root) {

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

	public static void breadthFirstSearch(GraphNode root) {

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

	public static boolean isRouteAvailable(GraphNode source, GraphNode destination) {

		// Base case
		if (source == destination) {
			return true;
		}

		/*
		 * find source node in graph using BFS find destination from source node using
		 * BFS
		 */

		return findNode(source, destination) != null ? true : false;

	}

	public static GraphNode findNode(GraphNode source, GraphNode destination) {
		GraphNode foundNode = null;

		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		GraphNode node;

		queue.offer(source);

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (!node.isVisited) {
				node.isVisited = true;
			}

			if (node == destination) {
				return node;
			}

			for (GraphNode child : node.children) {
				if (!child.isVisited) {
					queue.offer(child);
				}
			}
		}

		return foundNode;
	}
}
