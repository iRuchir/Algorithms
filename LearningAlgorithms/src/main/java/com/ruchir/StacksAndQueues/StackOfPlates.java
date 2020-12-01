package com.ruchir.StacksAndQueues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackOfPlates {

	int[][] stackOfPlates;
	int threshold;
	int currentActiveStack;
	int top = -1;

	public StackOfPlates(int numberOfStacks, int threshold) {
		this.threshold = threshold;
		stackOfPlates = new int[numberOfStacks][threshold];
	}

	public void push(int item) throws Exception {
		if (top + 1 < threshold) {
			top++;
			stackOfPlates[currentActiveStack][top] = item;
			return;
		} else if (currentActiveStack + 1 < stackOfPlates.length) {
			top = -1;
			currentActiveStack++;
			push(item);
		} else {
			throw new Exception("All stack plates are full, cannot insert any more elements." + item);
		}
	}

	public int pop() {
		int temp = 0;
		if (top == -1) {
			throw new EmptyStackException();
		}

		temp = stackOfPlates[currentActiveStack][top];
		stackOfPlates[currentActiveStack][top] = 0;

		if (top > 0) {
			top--;
		} else if (top == 0 && currentActiveStack != 0) {
			currentActiveStack--;
			top = threshold - 1;
		} else if (top == 0 && currentActiveStack == 0) {
			top--;
		}
		return temp;
	}

	public int peek() {
		if (top == -1)
			throw new EmptyStackException();

		return stackOfPlates[currentActiveStack][top];
	}

	public String toString() {
		return Arrays.deepToString(stackOfPlates);
	}
}
