package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {

	String name;
	List<DirectedGraphNode> children;
	List<DirectedGraphNode> parents;
	boolean isVisited = false;

	public DirectedGraphNode(String name) {
		this.name = name;
		children = new ArrayList<DirectedGraphNode>();
		parents = new ArrayList<DirectedGraphNode>();
	}

	public void addChild(DirectedGraphNode child) {
		children.add(child);
	}

	public void addParent(DirectedGraphNode parent) {
		parents.add(parent);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
