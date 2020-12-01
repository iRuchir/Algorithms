package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BuildOrder {

	public void createGraph(List<String> projects, List<List<String>> dependencies) {
		Map<String, DirectedGraphNode> mapOfProjects = new HashMap<String, DirectedGraphNode>();

		for (String project : projects) {
			mapOfProjects.merge(project, new DirectedGraphNode(project), (x, y) -> y);
		}

		DirectedGraphNode parent;
		DirectedGraphNode child;

		String project;
		Set<String> dependents = new HashSet<String>();
		Set<String> parents = new HashSet<String>();
		String dependent;

		for (List<String> pair : dependencies) {
			project = pair.get(0);
			dependent = pair.get(1);
			parent = mapOfProjects.get(project);
			child = mapOfProjects.get(dependent);

			parent.addChild(child);
			child.addParent(parent);

			dependents.add(dependent);
			parents.add(project);
		}

		List<String> nodesWithNoDependencies = new ArrayList<String>();

		for (String proj : mapOfProjects.keySet()) {
			if (!dependents.contains(proj)) {
				nodesWithNoDependencies.add(proj);
			}
		}

		DirectedGraphNode temp;

		Stack<String> buildOrder = new Stack<String>();
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

		for (String node : nodesWithNoDependencies) {
			mapOfProjects.get(node).isVisited = true;
			queue.add(mapOfProjects.get(node));
		}

		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (!allParentAreVisited(temp))
				queue.offer(temp);
			else {
				temp.isVisited = true;
				buildOrder.push(temp.name);
			}
			for (DirectedGraphNode childNode : temp.children) {
				if (!queue.contains(childNode) && !buildOrder.contains(childNode.name))
					queue.offer(childNode);
			}
		}
		System.out.println(buildOrder);

	}

	public boolean allParentAreVisited(DirectedGraphNode node) {
		for (DirectedGraphNode parent : node.parents) {
			if (!parent.isVisited)
				return false;
		}
		return true;
	}

}
