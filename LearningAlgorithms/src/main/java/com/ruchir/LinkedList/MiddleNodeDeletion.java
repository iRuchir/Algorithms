package com.ruchir.LinkedList;

public class MiddleNodeDeletion {
	public void deleteMiddleNode(Node node) {

		if (node == null || node.getNext() == null) {
			return;
		}

		node.data = node.getNext().data;
		node.setNext(node.getNext().getNext());
	}
}
