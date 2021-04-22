import java.util.*;

class Program {
	private static int maxSum;
	
	// O(n) time | O(log(n)) space
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
		maxSum = Integer.MIN_VALUE;
		dfs(tree);
    return maxSum;
  }
	
	private static int dfs(BinaryTree node) {
		if (node == null) {
			return 0;
		}
		int left = dfs(node.left);
		int right = dfs(node.right);
		int val = node.value;
		int maxSubTreeSum = Math.max(val, val + Math.max(left, right));
		maxSum = Math.max(maxSum, Math.max(left + val + right, maxSubTreeSum));
		return Math.max(val, Math.max(left + val, right + val));
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
