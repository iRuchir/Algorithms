package com.ruchir.LinkedList;

public class Partition {

	public Node doPartition2(Node head, int part) {

		Node current = head;
		Node newHead = head;
		Node newTail = head;

		while (current.getNext() != null) {
			Node temp = current;
			if (temp.data < part) {
				temp.setNext(newHead);
				newHead = temp;
			} else {
				newTail.setNext(temp);
				newTail = newTail.getNext();
			}
		}
		
		newTail.setNext(null);
		return newHead;

	}

	public Node doPartition(Node head, int part) {

		Node lowerStart = null;
		Node lowerEnd = null;
		Node higherStart = null;
		Node higherEnd = null;

		// Base case
		if (head == null || head.getNext() == null) {
			return null;
		}

		Node current = head;
		while (current.getNext() != null) {
			if (current.data < part) {
				if (lowerEnd == null) {
					lowerEnd = current;
					lowerStart = lowerEnd;
				} else {
					lowerEnd.setNext(current);
					lowerEnd = lowerEnd.getNext();
				}
			} else {
				if (higherEnd == null) {
					higherEnd = current;
					higherStart = higherEnd;
				} else {
					higherEnd.setNext(current);
					higherEnd = higherEnd.getNext();
				}
			}
		}

		if (lowerEnd == null) {
			return higherStart;
		}

		lowerEnd.setNext(higherStart);

		return lowerStart;
	}
}
