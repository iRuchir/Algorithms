package com.ruchir.LinkedList;

import java.util.Stack;

public class SumLists {

	public Node addListsForwardRecursive(Node list1, Node list2) {
		Stack<Integer> num1 = new Stack<Integer>();
		Stack<Integer> num2 = new Stack<Integer>();

		// Put both lists in stacks
		while (list1.getNext() != null) {
			num1.push(list1.data);
			list1 = list1.getNext();
		}

		while (list2.getNext() != null) {
			num2.push(list2.data);
			list2 = list2.getNext();
		}

		// Do calculations and add result to Stack
		int n1, n2, n, carry = 0;

		Stack<Integer> resultStack = new Stack<Integer>();

		Node result = null;
		Node resultHead = null;
		while (!num1.isEmpty() && !num2.isEmpty()) {
			n1 = (!num1.isEmpty()) ? num1.pop() : 0;
			n2 = (!num2.isEmpty()) ? num2.pop() : 0;

			n = (n1 + n2) % 10 + carry;

			carry = (n1 + n2) / 10;

			resultStack.push(n);
		}

		// Build a list from result stack
		Node node= null;
		while (!resultStack.isEmpty()) {
			node = new Node(resultStack.pop());
			if(result==null) {
				result = node;
				resultHead = node;
			} else {
				result.setNext(node);
				result = result.getNext();
			}
		}
		return resultHead;
	}

	public Node addLists2(Node list1, Node list2) {
		Node result = null;
		Node resultHead = null;
		int carry = 0;

		int n1 = 0;
		int n2 = 0;
		int n = 0;

		Node temp = null;

		while (list1 != null || list2 != null) {

			n1 = (list1 != null) ? list1.data : 0;
			n2 = (list2 != null) ? list2.data : 0;

			n = (n1 + n2 + carry) % 10;
			carry = (n1 + n2) / 10;

			temp = new Node(n);

			if (resultHead == null) {
				result = temp;
				resultHead = temp;
			} else {
				result.setNext(temp);
				result = result.getNext();
			}

			list1 = (list1 != null) ? list1.getNext() : null;
			list2 = (list2 != null) ? list2.getNext() : null;
		}

		return resultHead;
	}

	public int addLists(Node list1, Node list2) {
		int result = 0;
		int position = 1;

		int n1 = 0;
		int n2 = 0;

		while (list1.getNext() != null || list2.getNext() != null) {

			n1 = (list1 != null) ? list1.data : 0;
			n2 = (list2 != null) ? list2.data : 0;

			result += (n1 + n2) * position;
			position++;

			list1 = (list1 != null) ? list1.getNext() : null;
			list2 = (list2 != null) ? list2.getNext() : null;
		}

		return result;
	}

}
