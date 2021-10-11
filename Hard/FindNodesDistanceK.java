import java.util.*;

class Program {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	// O(n) time | O(n) space
	public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
		// Write your code here.
		ArrayList<Integer> nodesDistanceK = new ArrayList<Integer>();
		// we need to find the target node and then we can populate those nodes
		// that are exactly distance k from the target node.
		findTargetNode(tree, target, k, nodesDistanceK);
		return nodesDistanceK;
	}

	private static int findTargetNode(BinaryTree node, int target, int k, ArrayList<Integer> nodesDistanceK) {
		if (node == null) {
			return -1;
		}
		if (node.value == target) { // hit the target!!!
			populateSubtreeNodeAtDistanceK(node, k, nodesDistanceK); // populate all its subtree nodes with distance k
			return 1;
		}
		// keep searching for target node
		int leftDistance = findTargetNode(node.left, target, k, nodesDistanceK);
		int rightDistance = findTargetNode(node.right, target, k, nodesDistanceK);
		if (leftDistance == k || rightDistance == k) { // backtrack until the distance from target node is K
			nodesDistanceK.add(node.value);
		}
		// populate subtree nodes with distance k
		if (leftDistance != -1) {
			populateSubtreeNodeAtDistanceK(node.right, k - leftDistance - 1, nodesDistanceK);
			return leftDistance + 1;
		}
		if (rightDistance != -1) {
			populateSubtreeNodeAtDistanceK(node.left, k - rightDistance - 1, nodesDistanceK);
			return rightDistance + 1;
		}
		return -1;
	}

	private static void populateSubtreeNodeAtDistanceK(BinaryTree node, int k, ArrayList<Integer> nodesDistanceK) {
		if (node == null) {
			return;
		}
		if (k == 0) {
			nodesDistanceK.add(node.value);
		} else {
			populateSubtreeNodeAtDistanceK(node.left, k - 1, nodesDistanceK);
			populateSubtreeNodeAtDistanceK(node.right, k - 1, nodesDistanceK);
		}
	}
}
