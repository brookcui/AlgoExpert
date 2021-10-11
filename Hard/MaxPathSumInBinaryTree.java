import java.util.*;

class Program {
	public static int maxPathSum(BinaryTree tree) {
		// Write your code here.
		int[] pair = helper(tree);
		return pair[1];
	}

	private static int[] helper(BinaryTree root) {
		if (root == null) { // base case at leaf nodes
			return new int[] { 0, Integer.MIN_VALUE };
		}
		// left subtree visited
		int[] leftPair = helper(root.left);
		int leftBranchSum = leftPair[0];
		int leftMaxPathSum = leftPair[1];
		// right subtree visited
		int[] rightPair = helper(root.right);
		int rightBranchSum = rightPair[0];
		int rightMaxPathSum = rightPair[1];
		// compute greater branch sum with current root value
		int rootValue = root.value;
		int maxBranchSum = Math.max(rootValue, Math.max(leftBranchSum + rootValue, rightBranchSum + rootValue));
		// compute path sum at current root node
		int currentPathSum = leftBranchSum + rootValue + rightBranchSum;
		int maxPathSum = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum), Math.max(currentPathSum, maxBranchSum));
		return new int[] { maxBranchSum, maxPathSum };
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}
}
