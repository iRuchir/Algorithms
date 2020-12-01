package com.ruchir.TreesAndGraphs;

public class BinaryTreeNode {
	String name;
	public BinaryTreeNode left, right, parent;
	
	public BinaryTreeNode(String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}
}
