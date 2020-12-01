package com.ruchir.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	String name;
//	public GraphNode[] children;
	public List<GraphNode> children;
	boolean isVisited;
	
	public GraphNode(String name) {
		this.name = name;
		children = new ArrayList<GraphNode>();
	}
}
