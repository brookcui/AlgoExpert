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

	// O(nlog(n)) time | O(log(n)) space
  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
		if (tree == null) {
			return true;
		}
		int left = height(tree.left);
		int right = height(tree.right);
		return Math.abs(left - right) < 2
			&& heightBalancedBinaryTree(tree.left)
			&& heightBalancedBinaryTree(tree.right);
  }
	
	private int height(BinaryTree node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
