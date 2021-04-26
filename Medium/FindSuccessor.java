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

	// O(log(n)) time | O(1) space
  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		if (tree == null || node == null) {
			return null;
		}
		if (node.right != null) {
			BinaryTree successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			return successor;
		}
		BinaryTree prev = null;
		BinaryTree curr = tree;
		Stack<BinaryTree> stack = new Stack<>();
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (prev != null && prev == node) {
				return curr;
			}
			prev = curr;
			curr = curr.right;
		}
    return null;
  }
}
