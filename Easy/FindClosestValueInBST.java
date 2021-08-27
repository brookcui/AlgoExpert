import java.util.*;

class Program {
	// Average: O(log(n)) time | O(log(n)) space
	// Worst: O(n) time | O(n) space
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		return helper(tree, target, tree.value);
  }
	
	private static int helper(BST node, int target, int cloest) {
		if (Math.abs(node.value - target) <= Math.abs(cloest - target)) {
			cloest = node.value;
		}
		if (target < node.value && node.left != null) {
			return helper(node.left, target, cloest);
		} else if (target > node.value && node.right != null) {
			return helper(node.right, target, cloest);
		} else { // exact match
			return cloest;
		}
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
