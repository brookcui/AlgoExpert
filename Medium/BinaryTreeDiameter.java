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

	// O(n) time | O(h) space
	public int binaryTreeDiameter(BinaryTree tree) {
		// Write your code here.
		return helper(tree)[0];
	}

	private static int[] helper(BinaryTree root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}
		int[] leftTreeDiameterAndHeight = helper(root.left);
		int[] rightTreeDiameterAndHeight = helper(root.right);
		int leftTreeDiameter = leftTreeDiameterAndHeight[0];
		int leftTreeHeight = leftTreeDiameterAndHeight[1];
		int rightTreeDiameter = rightTreeDiameterAndHeight[0];
		int rightTreeHeight = rightTreeDiameterAndHeight[1];
		int maxDiameterSoFar = Math.max(leftTreeDiameter, rightTreeDiameter);
		int longestPath = leftTreeHeight + rightTreeHeight;
		int maxDiameter = Math.max(maxDiameterSoFar, longestPath);
		int height = 1 + Math.max(leftTreeHeight, rightTreeHeight);
		return new int[] { maxDiameter, height };
	}
}
