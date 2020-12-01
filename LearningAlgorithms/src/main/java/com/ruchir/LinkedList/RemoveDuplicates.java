package com.ruchir.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	// Use Two Pointers, one to check current and other to verify if duplicate, and
	// then delete duplicate pointed by second pointer

	public void removeDupsSet(Node head) {
		Set<Integer> set = new HashSet<Integer>();
		Node node = head;
		Node previous = null;
		while (node.getNext() != null) {
			if (set.contains(node.data)) {
				// remove node
				previous.setNext(node.getNext());
			} else {
				set.add(node.data);
				previous = node;
			}
			node = node.getNext();
		}

	}

	public void removeDups(Node head) {

		Node currentNode = head;
		Node otherNode = currentNode;

		while (currentNode.getNext() != null) {
			while (otherNode.getNext() != null) {
				if (currentNode.data == otherNode.getNext().data) {
					// Remove other node
					otherNode.setNext(otherNode.getNext().getNext());
				}
				otherNode = otherNode.getNext();
			}
			currentNode = currentNode.getNext();
		}

	}

}
