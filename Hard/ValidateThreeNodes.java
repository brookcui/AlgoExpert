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

	// O(h) time | O(h) space
	public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
		// Write your code here.
		// nodeThree > nodeTwo > nodeOne
		if (isDescendant(nodeTwo, nodeOne)) {
			return isDescendant(nodeThree, nodeTwo);
		}
		// nodeOne > nodeTwo > nodeThree
		if (isDescendant(nodeTwo, nodeThree)) {
			return isDescendant(nodeOne, nodeTwo);
		}
		return false;
	}

	// Note that we are given a BST and thus we can check values of
	// both nodes to perform a top-bottom search and seek a descendant node
	private boolean isDescendant(BST node, BST descendant) {
		if (node == null) {
			return false;
		}
		if (node == descendant) {
			return true;
		}
		return (descendant.value < node.value) ? isDescendant(node.left, descendant)
				: isDescendant(node.right, descendant);
	}
}
