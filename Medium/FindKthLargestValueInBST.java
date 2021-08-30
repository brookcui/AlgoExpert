import java.util.*;

class Program {
	// This is an input class. Do not edit.
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	// O(n) time | O(n) space - where n is the number of nodes in the tree
	public int findKthLargestValueInBst(BST tree, int k) {
		// Write your code here.
		List<Integer> sortedValues = new ArrayList<>();
		inorderTraverse(tree, sortedValues);
		return sortedValues.get(sortedValues.size() - k);
	}

	private static void inorderTraverse(BST root, List<Integer> values) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left, values);
		values.add(root.value);
		inorderTraverse(root.right, values);
	}
}
