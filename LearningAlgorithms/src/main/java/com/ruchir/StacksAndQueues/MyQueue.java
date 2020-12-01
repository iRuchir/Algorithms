package com.ruchir.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

	public void add() {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			queue.offer(i);
		for (int i = 0; i < 10; i++)
			System.out.println(queue.poll());
	}
}
