package com.ruchir.ArraysAndStrings;

import java.util.EmptyStackException;
import java.util.Stack;

public class SortStack {
	public Stack<Integer> sortIt(Stack<Integer> stack) {
		Stack<Integer> sortedStack = new Stack<Integer>();

		// Base Cases
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		} else if (stack.size() < 2) {
			return stack;
		}

		// Get maximum and store on another stack
		int temp;
		while (!stack.isEmpty()) {
			// Base case
			temp = stack.pop();
			if (sortedStack.isEmpty()) {
				sortedStack.push(temp);
			} else {
				while (!sortedStack.isEmpty() && temp > sortedStack.peek()) {
					stack.push(sortedStack.pop());
				}
				sortedStack.push(temp);
				while (!stack.isEmpty() && stack.peek() < sortedStack.peek()) {
					sortedStack.push(stack.pop());
				}
			}
		}

		return sortedStack;
	}
}
