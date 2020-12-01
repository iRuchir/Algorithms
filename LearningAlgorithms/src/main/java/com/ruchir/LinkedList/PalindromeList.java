package com.ruchir.LinkedList;

import java.util.Stack;

public class PalindromeList {

	public boolean isPalindrome(Node head) {
		Node current = head;
		
		int size = 0;

		while (current.getNext() != null) {
			size++;
			current = current.getNext();
		}
		
		current = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		
		for(int i = 0; i < size/2 ; i++) {
			stack.push(current.data);
			current = current.getNext();
		}
		
		if(size % 2 != 0) {
			current = current.getNext();
		}
		
		int num = 0;
		
		for(int i = 0; i < size/2 ; i++) {
			num = stack.pop();
			if(num != current.data)
				return false;
			current = current.getNext();
		}
		
		return true;
	}

}
