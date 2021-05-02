import java.util.*;

class Program {
	// O(n) time | O(d) space
  public static boolean validateBst(BST tree) {
    // Write your code here.
    return isBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

	private static boolean isBst(BST tree, int lower, int upper) {
		if (tree == null) {
			return true;
		}
		int value = tree.value;
		if (value < lower || value >= upper) {
			return false;
		}
		return isBst(tree.left, lower, value) && isBst(tree.right, value, upper);
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
