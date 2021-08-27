import java.util.*;

class Program {
	// O(n) time | O(log(n)) space - where n is the number of nodes in the binary tree
  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    return helper(root, 0, 0);
  }
	
	private static int helper(BinaryTree root, int depth, int nodeDepthsSum) {
		if (root == null) {
			return 0;
		}
		return depth + helper(root.left, depth + 1, nodeDepthsSum) + helper(root.right, depth + 1, nodeDepthsSum);
	}

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
