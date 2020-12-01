package com.ruchir.ArraysAndStrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.swing.plaf.TreeUI;

import org.junit.jupiter.api.Test;

import com.ruchir.StacksAndQueues.MyQueue;
import com.ruchir.StacksAndQueues.StackOfPlates;
import com.ruchir.StacksAndQueues.StackOfPlatesLL;
import com.ruchir.TreesAndGraphs.BinarySearchTree;
import com.ruchir.TreesAndGraphs.BinaryTreeNode;
import com.ruchir.TreesAndGraphs.BuildOrder;
import com.ruchir.TreesAndGraphs.FirstCommonAncestor;
import com.ruchir.TreesAndGraphs.GraphNode;
import com.ruchir.TreesAndGraphs.GraphUtils;
import com.ruchir.TreesAndGraphs.ListOfDepths;
import com.ruchir.TreesAndGraphs.TreeBalanceUtil;
import com.ruchir.TreesAndGraphs.TreeTraversal;
import com.ruchir.TreesAndGraphs.TreeUtils;
import com.ruchir.google.adhoc.Meetings;

class Runner {

	@Test
	void test() {
		System.out.println("Testing in Runner");
	}

	@Test
	void createBinaryTree() {
		String treeString = "1;2,3;4,5;6,7;12,NULL;10,11;NULL,9;NULL,8;NULL,13;NULL,19;NULL,NULL;18,NULL;NULL,16;14,15;NULL,20;NULL,NULL;17,NULL;NULL,NULL;NULL,NULL;NULL,NULL;NULL,NULL";

		TreeUtils.createBinaryTree(TreeUtils.stringToListOfNodes(treeString));
	}

//	@Test
	void findFirstCommonAncestor() {
		BinaryTreeNode root = new BinaryTreeNode("1");
		root.left = new BinaryTreeNode("2");
		root.left.parent = new BinaryTreeNode("1");
		root.right = new BinaryTreeNode("3");
		root.right.parent = new BinaryTreeNode("1");

		FirstCommonAncestor ancestor = new FirstCommonAncestor();
		ancestor.findCommonAncestor(root, root.left.right.right.right, root.left.left.left);

	}

	// @Test
	void testBuildOrder() {
		BuildOrder buildOrder = new BuildOrder();

		List<String> projects = new ArrayList<String>();
		projects.add("a");
		projects.add("b");
		projects.add("c");
		projects.add("d");
		projects.add("e");
		projects.add("f");
		projects.add("g");
		projects.add("i");
		List<List<String>> listOfPairs = new ArrayList<List<String>>();
		// (a, d), (f, b), (b, d), (f, a), (d, c)
		List<String> pair = new ArrayList<String>();
		pair.add("a");
		pair.add("d");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("f");
		pair.add("b");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("b");
		pair.add("d");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("f");
		pair.add("a");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("d");
		pair.add("c");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("d");
		pair.add("e");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("e");
		pair.add("c");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("d");
		pair.add("i");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("i");
		pair.add("g");
		listOfPairs.add(pair);

		pair = new ArrayList<String>();
		pair.add("g");
		pair.add("c");
		listOfPairs.add(pair);

		buildOrder.createGraph(projects, listOfPairs);
	}

	// @Test
	void testIfBinarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		List<BinaryTreeNode> list = Arrays.stream(elements).boxed().map(x -> new BinaryTreeNode(x.toString()))
				.collect(Collectors.toList());

		BinaryTreeNode root = new BinaryTreeNode("8");
		root.left = new BinaryTreeNode("4");
		root.left.left = new BinaryTreeNode("2");
		root.left.left.left = new BinaryTreeNode("1");
		root.left.left.right = new BinaryTreeNode("3");
		root.left.right = new BinaryTreeNode("6");
		root.left.right.left = new BinaryTreeNode("5");
		root.left.right.right = new BinaryTreeNode("7");

		root.right = new BinaryTreeNode("12");
		// root.right.left = new BinaryTreeNode("10");
		// root.right.left.left = new BinaryTreeNode("9");
		// root.right.left.right = new BinaryTreeNode("11");
		root.right.right = new BinaryTreeNode("14");
		root.right.right.left = new BinaryTreeNode("13");
		root.right.right.right = new BinaryTreeNode("15");

		binarySearchTree.getSuccessor(root);

		// System.out.println(BinarySearchTree.isBinarySearchTree((root)));
	}

//	@Test
	void testIfBalancedTree() {

		BinaryTreeNode root = new BinaryTreeNode("1");
		root.left = new BinaryTreeNode("2");
		root.left.left = new BinaryTreeNode("4");
		root.left.left.left = new BinaryTreeNode("8");
		root.left.left.left.left = new BinaryTreeNode("13");
		root.left.left.left.left.left = new BinaryTreeNode("14");
		root.left.right = new BinaryTreeNode("5");
		root.left.right.right = new BinaryTreeNode("9");
		root.left.right.right.right = new BinaryTreeNode("10");

		root.right = new BinaryTreeNode("3");
		root.right.left = new BinaryTreeNode("6");
		root.right.left.left = new BinaryTreeNode("11");
		root.right.right = new BinaryTreeNode("7");
		root.right.right.right = new BinaryTreeNode("12");

		TreeBalanceUtil treeBalanceUtil = new TreeBalanceUtil();

		System.out.println(treeBalanceUtil.checkIfBalanced(root));
	}

//	@Test
	void testListOfDepths() {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		List<BinaryTreeNode> list = Arrays.stream(elements).boxed().map(x -> new BinaryTreeNode(x.toString()))
				.collect(Collectors.toList());
		System.out.println(list);
		// TreeTraversal.inOrderTraversal(binarySearchTree.createBinarySerachTree(list));
		ListOfDepths listOfDepths = new ListOfDepths();
		ArrayList<LinkedList<BinaryTreeNode>> lists = listOfDepths
				.createLevelLinkedList(binarySearchTree.createBinarySerachTree(list));
		System.out.println(lists);
	}

//	@Test
	void testBinarySearchTree() {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		binarySearchTree.createBinarySerachTree(elements);
	}

//	@Test
	void testGraphSearch() {

		GraphNode root = new GraphNode("0");

		GraphNode one = new GraphNode("1");
		GraphNode two = new GraphNode("2");
		GraphNode three = new GraphNode("3");
		GraphNode four = new GraphNode("4");
		GraphNode five = new GraphNode("5");

		root.children.add(one);
		root.children.add(four);
		root.children.add(five);

		one.children.add(three);
		one.children.add(four);

		two.children.add(one);

		three.children.add(two);
		three.children.add(four);

		// search.breadthFirstSearch(root);
		System.out.println(GraphUtils.isRouteAvailable(two, five));

	}

//	@Test
	void testTreeTraversal() {
		BinaryTreeNode root = new BinaryTreeNode("10");
		root.left = new BinaryTreeNode("5");
		root.left.right = new BinaryTreeNode("12");
		root.right = new BinaryTreeNode("20");
		root.right.right = new BinaryTreeNode("7");
		root.right.left = new BinaryTreeNode("3");
		root.right.left.right = new BinaryTreeNode("18");
		root.right.left.left = new BinaryTreeNode("9");

		TreeTraversal.inOrderTraversal(root);
		System.out.println();
		TreeTraversal.preOrderTraversal(root);
		System.out.println();
		TreeTraversal.postOrderTraversal(root);
	}

//	@Test
	void testMeetings() {
		Meetings meetings = new Meetings();

		// Adding bounds for person 1
		List<Integer> dailyBound1 = new ArrayList<Integer>();
		dailyBound1.add(900);
		dailyBound1.add(2000);

		// Adding bounds for person 2
		List<Integer> dailyBound2 = new ArrayList<Integer>();
		dailyBound2.add(1000);
		dailyBound2.add(2030);

		List<List<Integer>> busySlots1 = new ArrayList<List<Integer>>();
		List<List<Integer>> busySlots2 = new ArrayList<List<Integer>>();

		List<Integer> busySlot = new ArrayList<Integer>();
		busySlot.add(900);
		busySlot.add(1030);
		busySlots1.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1200);
		busySlot.add(1300);
		busySlots1.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1600);
		busySlot.add(1800);
		busySlots1.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1900);
		busySlot.add(1930);
		busySlots1.add(busySlot);

		// Adding busy slots for 2nd Person
		busySlot = new ArrayList<Integer>();
		busySlot.add(1000);
		busySlot.add(1130);
		busySlots2.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1230);
		busySlot.add(1430);
		busySlots2.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1430);
		busySlot.add(1500);
		busySlots2.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1600);
		busySlot.add(1700);
		busySlots2.add(busySlot);

		busySlot = new ArrayList<Integer>();
		busySlot.add(1930);
		busySlot.add(2030);
		busySlots2.add(busySlot);
		/*
		 * System.out.println(dailyBound1); System.out.println(dailyBound2);
		 * System.out.println(busySlots1); System.out.println(busySlots2);
		 */

		System.out.println(busySlots1);
		System.out.println(busySlots2);
		// Get effective bounds
		int meetingDuration = 60;
		/*
		 * System.out.println(meetings.getEffectiveBounds(dailyBound1, dailyBound2));
		 * System.out.println(meetings.findCommonSlots(meetings.getFreeSlots(busySlots1,
		 * meetingDuration), meetings.getFreeSlots(busySlots2, meetingDuration),
		 * meetingDuration));
		 */
		meetings.getEffectiveBounds(dailyBound1, dailyBound2);
		System.out.println(meetings.findCommonSlots(meetings.getFreeSlots(busySlots1, meetingDuration),
				meetings.getFreeSlots(busySlots2, meetingDuration), meetingDuration));
	}

//	@Test
	void testAnimalShelter() {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog("Jackie"));
		shelter.enqueue(new Dog("BullD"));
		shelter.enqueue(new Cat("Tom"));
		shelter.enqueue(new Dog("Cizer"));
		shelter.enqueue(new Cat("Aglet"));
		shelter.enqueue(new Cat("Neon"));
		System.out.print("Initial Shelter:");
		System.out.println(shelter);
		System.out.print("Dequeuing Cat:");
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);
		System.out.print("Dequeuing Any:");
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter);
		System.out.print("Dequeuing Dog:");
		System.out.println(shelter.dequeueDog());
		System.out.println(shelter);
		System.out.print("Dequeuing Cat:");
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);
		System.out.print("Dequeuing Cat:");
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);
		System.out.print("Dequeuing Cat:");
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter);
	}

//	@Test
	void testSortStack() {
		SortStack sortStack = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(7);
		stack.push(1);
		stack.push(9);
		stack.push(2);
		stack.push(4);
		System.out.println(stack);
		System.out.println(sortStack.sortIt(stack));
	}

//	@Test
	void testMyQueue() {
		MyQueue queue = new MyQueue();
		queue.add();
	}

//	@Test
	void testStackOfPlatesLL() {
		StackOfPlatesLL stack = new StackOfPlatesLL(5);
		try {
			for (int i = 1; i < 19; i++) {
				stack.push(i);
			}
			System.out.println(stack);
			stack.pop(2);
			System.out.println(stack);
			stack.pop(1);
			System.out.println(stack);
			stack.pop(1);
			System.out.println(stack);
			stack.pop();
			System.out.println(stack);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Test
	void testStackOfPlates() {
		StackOfPlates plates = new StackOfPlates(9, 3);
		for (int i = 0; i < 22; i++) {
			try {
				plates.push(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(plates);
		}
		for (int i = 0; i < 23; i++) {
			plates.pop();
		}
		System.out.println(plates);
		System.out.println(plates.peek());
		System.out.println(plates);
	}

//	@Test
	void testStringRotation() {
		StringRotation rotation = new StringRotation();
		assertEquals(true, rotation.isRotationOf("candyman", "dymancan"));
		assertEquals(true, rotation.isRotationOf("candyman", "ncandyma"));
		assertEquals(true, rotation.isRotationOf("waterbottle", "tlewaterbot"));
		assertEquals(true, rotation.isRotationOf("waterbottle", "erbottlewat"));
	}

//	@Test
	void testStringCompression() {
		StringCompression compression = new StringCompression();
		String str = "aabcccccaaa";
		System.out.println(compression.getCompressedString(str));
	}

//	@Test
	void testOneEditAway() {
		OneEditAway oneEditAway = new OneEditAway();
		String str1 = "pale";
		String str2 = "bake";
		System.out.println(oneEditAway.isOneEditAway(str1, str2));
	}

//	@Test
	void testURLify() {
		URLify urLify = new URLify();
		System.out.println(urLify.urlifyString("Mr John Smith"));
	}

//	@Test
	void testTwoStringPermutations() {
		TwoStringPermutation twoStringPermutation = new TwoStringPermutation();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < 100000; i++) {
			str1 += "a";
			str2 += "a";
		}
		System.out.println(twoStringPermutation.isPermutation(str1, str2));
	}

//	@Test
	void testTwoStringPermutationsSorted() {
		TwoStringPermutation twoStringPermutation = new TwoStringPermutation();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < 100000; i++) {
			str1 += "a";
			str2 += "a";
		}
		System.out.println(twoStringPermutation.isPermutationSorted(str1, str2));
	}

// @Test
	void testNthFibo() {
		Fibonacci fibonacci = new Fibonacci();
		int n = 45;
		int expected = 13;
		int actual = fibonacci.nthFibo(n);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

// @Test
	void testNthFiboWithCache() {
		Fibonacci fibonacci = new Fibonacci();
		int n = 45;
		int expected = 13;
		int[] alreadyExists = new int[n + 1];
		int actual = fibonacci.nthFiboWithCache(n, alreadyExists);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

//	@Test
	void testPowerOf2() {
		PowerOf2 of2 = new PowerOf2();
		of2.calculatePowerOf2(200000);
	}

//	@Test
	void testPowerOf2Recursive() {
		PowerOf2 of2 = new PowerOf2();
		of2.calculatePowerOf2Recursive(9);
	}
}
