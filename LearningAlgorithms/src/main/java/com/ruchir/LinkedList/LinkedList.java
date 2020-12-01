package com.ruchir.LinkedList;

public class LinkedList {

	Node deleteNode(Node head, int d) {

		Node n = head;
		if (n.data == d) {
			return head.getNext();
		}

		while (n.getNext() != null) {
			if (n.getNext().data == d) {
				n.setNext(n.getNext().getNext());
				return head;
			}
			n = n.getNext();
		}

		return head;
	}

}
