import java.util.*;

class Program {
	// O(n) time | O(log(n)) space
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
		if (tree == null) {
			return;
		}
		// mirror
		BinaryTree left = tree.left;
		tree.left = tree.right;
		tree.right = left;
		// invert childrens
		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);
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
