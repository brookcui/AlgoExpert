import java.util.*;

class Program {
	// Average: O(log(n)) time | O(1) space
	// Worst: O(n) time | O(1) space
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		int closest = tree.value;
		BST curr = tree;
		while (curr != null) {
			if (Math.abs(curr.value - target) <= Math.abs(closest - target)) {
				closest = curr.value;
			}
			if (target < curr.value && curr.left != null) {
				curr = curr.left;
			} else if (target > curr.value && curr.right != null) {
				curr = curr.right;
			} else {
				break;
			}
		}
    return closest;
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
