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

	private static int diameter;

	// O(n) time | O(log(n)) space
  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
		if (tree == null) {
			return 0;
		}
		diameter = 0;
		dfs(tree);
    return diameter;
  }
	
	private int dfs(BinaryTree tree) {
		if (tree == null) {
			return 0;
		}
		int left = dfs(tree.left);
		int right = dfs(tree.right);
		int largerDepth = Math.max(left, right);
		diameter = Math.max(diameter, Math.max(left + right, largerDepth));
		return 1 + Math.max(left, right);
	}
}
