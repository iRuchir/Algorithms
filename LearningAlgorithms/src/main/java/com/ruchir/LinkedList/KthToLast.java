package com.ruchir.LinkedList;

public class KthToLast {

	public int getKthToLastSliding(int k, Node head) {
		
		// Maintain sliding window of two pointers k distance apart
		// move runner k positions ahead of current
		// move current and runner like a sliding window until runner.next != null
		// then, current would be at kth from the last position, return current.data
		Node current = head;
		Node runner = current;
		int count = 1;

		
		while (count != k) {
			runner = runner.getNext();
			count++;
		}
		
		while(runner.getNext() != null) {
			current = current.getNext();
			runner = runner.getNext();
		}
		
		return current.data;

	}

	public int getKthToLast(int k, Node head) {
		Node current = head;

		// 7 -> 9 -> 3 -> 4 -> 5 -> 2 -> 9 -> 7 -> 9 -> 4 -> 2
		int count = 1;
		while (current.getNext() != null) {
			count++;
			current = current.getNext();
		}

		current = head;

		int count2 = 1;
		while (current.getNext() != null) {
			count2++;
			current = current.getNext();
			if (count - count2 == k) {
				return current.data;
			}
		}

		return 0;
	}

}
