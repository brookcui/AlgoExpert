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

	// O(n^2) time | O(n) space - where n is the length of the input array
	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		// Write your code here.
		return constructBstFromPreorderValues(preOrderTraversalValues, 0, preOrderTraversalValues.size() - 1);
	}

	private static BST constructBstFromPreorderValues(ArrayList<Integer> values, int startIdx, int endIdx) {
		if (startIdx > endIdx) {
			return null;
		}
		int value = values.get(startIdx);
		int rightSubtreeRootIdx = endIdx + 1;
		for (int idx = startIdx + 1; idx <= endIdx; idx++) {
			if (values.get(idx) >= value) {
				rightSubtreeRootIdx = idx;
				break;
			}
		}
		BST root = new BST(value);
		root.left = constructBstFromPreorderValues(values, startIdx + 1, rightSubtreeRootIdx - 1);
		root.right = constructBstFromPreorderValues(values, rightSubtreeRootIdx, endIdx);
		return root;
	}
}
