package com.ruchir.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {
	public Node detectLoop(Node head) {
		Set<Integer> hashCodes = new HashSet<Integer>();
		Node temp = head;

		while (temp.getNext() != null) {
			if (hashCodes.contains(temp.hashCode())) {
				return temp;
			}
			hashCodes.add(temp.hashCode());
			temp = temp.getNext();
		}
		return null;
	}
}
