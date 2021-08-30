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

	private static boolean isBalanced;

	// O(n) time | O(h) space
	public boolean heightBalancedBinaryTree(BinaryTree tree) {
		// Write your code here.
		if (tree == null) {
			return true;
		}
		isBalanced = true;
		helper(tree);
		return isBalanced;
	}

	private static int helper(BinaryTree root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = helper(root.left);
		if (!isBalanced) {
			return -1;
		}
		int rightHeight = helper(root.right);
		if (!isBalanced || Math.abs(leftHeight - rightHeight) > 1) {
			isBalanced = false;
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
