package com.ruchir.TreesAndGraphs;

import com.ruchir.exception.DataStructureException;
import com.ruchir.exception.UnbalancedTreeException;

public class TreeBalanceUtil {

	boolean isBalanced = false;

	enum nodeSide {
		LEFT, RIGHT
	}

	public boolean checkIfBalanced(BinaryTreeNode root) {
		try {
			heightOfNode(root);
		} catch (DataStructureException e) {
			e.printStackTrace();
		}
		return isBalanced;
	}

	public int heightOfNode(BinaryTreeNode node) throws UnbalancedTreeException {
		int heightRight = 0;
		int heightLeft = 0;

		if (node.left != null) {
			heightLeft = heightOfNode(node.left) - 1;
		}

		if (node.right != null) {
			heightRight = heightOfNode(node.right) + 1;
		}


		int height = heightRight + heightLeft;

		System.out.println(node.name + " -> " + height);

		if (Math.abs(height) > 1) {
			throw new UnbalancedTreeException("Tree is not balanced at node --> " + node.name);
		}

		return height;
	}

}
