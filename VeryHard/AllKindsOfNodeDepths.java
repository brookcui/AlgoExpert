import java.util.*;

class Program {
	// O(nlog(n)) time | O(h) space
  public static int allKindsOfNodeDepths(BinaryTree root) {
    // Write your code here.
		if (root == null) {
			return 0;
		}
		return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepth(root, 0);
  }

	private static int nodeDepth(BinaryTree node, int depth) {
		if (node == null) {
			return 0;
		}
		int left = nodeDepth(node.left, depth + 1);
		int right = nodeDepth(node.right, depth + 1);
		return depth + left + right;
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
