import java.util.*;

class Program {
  // O(n) time | O(h) space - where n is the number of nodes in the candidate BST
  // and h is the height of the BST
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return validateBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean validateBST(BST root, int lowerBound, int upperBound) {
    if (root == null) {
      return true;
    }
    int value = root.value;
    if (value < lowerBound || value >= upperBound) {
      return false;
    }
    return validateBST(root.left, lowerBound, value) && validateBST(root.right, value, upperBound);
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
