import java.util.*;

class Program {
  // O(n) time | O(log(n)) space
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
    if (tree == null) {
      return;
    }
    BinaryTree temp = tree.right;
    tree.right = tree.left;
    tree.left = temp;
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
