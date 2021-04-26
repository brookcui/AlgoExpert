import java.util.*;

// Solution 1
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

	// O(nlog(n)) time | O(log(n)) space
  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
		if (tree == null) {
			return true;
		}
		int left = height(tree.left);
		int right = height(tree.right);
		return Math.abs(left - right) < 2
			&& heightBalancedBinaryTree(tree.left)
			&& heightBalancedBinaryTree(tree.right);
  }
	
	private int height(BinaryTree node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}

// Solution 2
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

	class Pair<U, V> {
		U first;
		V second;
		
		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}

	// O(n) time | O(n) space
  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    return helper(tree).second;
  }

  private Pair<Integer, Boolean> helper(BinaryTree node) {
    // Write your code here.
		if (node == null) {
			return new Pair<>(-1, true);
		}
		Pair<Integer, Boolean> left = helper(node.left);
		if (!left.second) {
			return new Pair<>(-1, false);
		}
		Pair<Integer, Boolean> right = helper(node.right);
		if (!right.second) {
			return new Pair<>(-1, false);
		}
		if (Math.abs(left.first - right.first) < 2) {
			return new Pair<>(Math.max(left.first, right.first) + 1, true);
		}
    return new Pair<>(-1, false);
  }
}
