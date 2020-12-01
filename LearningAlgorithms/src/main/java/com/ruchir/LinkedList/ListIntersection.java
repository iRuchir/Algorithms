package com.ruchir.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class ListIntersection {
	public Node intersectionBruteForce(Node list1, Node list2) {

		while (list1.getNext() != null) {
			while (list2.getNext() != null) {
				if (list1 == list2) {
					return list1;
				}
				list2 = list2.getNext();
			}
			list1 = list1.getNext();
		}

		return null;
	}

	public Node intersectionHashcode(Node list1, Node list2) {

		Set<Integer> list1Hashes = new HashSet<Integer>();

		while (list1.getNext() != null) {
			list1Hashes.add(list1.hashCode());
			list1 = list1.getNext();
		}

		while (list2.getNext() != null) {
			if (list1Hashes.contains(list2.hashCode())) {
				return list2;
			}
			list2 = list2.getNext();
		}

		return null;
	}

}
