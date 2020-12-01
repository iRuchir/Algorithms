package com.ruchir.StacksAndQueues;

import java.util.EmptyStackException;

import com.ruchir.LinkedList.Node;

public class StackOfPlatesLL {

	int threshold;
	int numberOfElements;
	Node top;

	public StackOfPlatesLL(int threshold) {
		this.threshold = threshold;
	}

	public void push(int item) throws Exception {

		Node node = new Node(item);
		numberOfElements++;

		// Base cases
		if (top == null) {
			top = node;
			return;
		}

		node.next = top;
		top = node;
	}

	public int pop() {
		if (numberOfElements == 0) {
			throw new EmptyStackException();
		}
		Node temp = top;
		top = top.next;

		temp.next = null;

		numberOfElements--;
		return temp.data;
	}

	public int pop(int stackIndex) {
		int totalNumberOfStacks = numberOfElements / threshold + 1;
		Node temp;
		int nodeData;
		if (stackIndex > totalNumberOfStacks || stackIndex < 0) {
			throw new IllegalStateException("Stack index not available or invalid index.");
		}
		if (stackIndex < totalNumberOfStacks) {
			temp = getKthElement(top, numberOfElements - (stackIndex * 5));
			nodeData = temp.data;
			temp.next = temp.next.next;
			numberOfElements--;
			return nodeData;
		} else {
			temp = top;
			top = top.next;
			numberOfElements--;
			return temp.data;
		}
	}

	public Node getKthElement(Node topNode, int k) {
		for (int i = 0; i < k - 1; i++) {
			topNode = topNode.next;
		}
		return topNode;
	}

	public int peek() {
		return top.data;
	}

	public String toString() {
		Node node = top;
		StringBuilder string = new StringBuilder();
		while (node.next != null) {
			string.append(node.data + " -> ");
			node = node.next;
		}
		string.append(node.data + " -> NULL");
		return string.toString();
	}
}
