package com.ruchir.LinkedList;

public class Node {
	public int data;
	public Node next;
	public boolean isHeadNode = false;

	public Node(int data) {
		this.data = data;
	}

	public void setHead(boolean isHead) {
		isHeadNode = isHead;
	}

	public boolean isHead() {
		return isHeadNode;
	}

	void appendToTail(int d) {
		Node node = new Node(d);
		Node temp = this;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(node);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
