import java.util.*;

class Program {
	// This is an input class. Do not edit.
	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	// O(n) time | O(log(n)) space
	public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		// Write your code here.
		Stack<BinaryTree> stack = new Stack<>();
		BinaryTree curr = tree;
		BinaryTree prev = null;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (prev == node) {
				return curr;
			}
			prev = curr;
			curr = curr.right;
		}
		return null;
	}
}
