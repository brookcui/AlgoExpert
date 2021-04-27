import java.util.function.Function;
import java.util.*;

// Solution 1
class Program {
 	// O(n) time | O(n) space
  public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
    // Write your code here.
		Stack<BinaryTree> stack = new Stack<>();
		BinaryTree curr = tree;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			curr = stack.pop();
			callback.apply(curr);
			curr = curr.right;
		}
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}

// Solution 2
class Program {
	// O(n) time | O(1) space
  public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
    // Write your code here.
		BinaryTree prev = null;
		BinaryTree curr = tree;
		while (curr != null) {
			BinaryTree next = null;
			if (prev == null || prev == curr.parent) {
				if (curr.left != null) {
					next = curr.left;
				} else {
					callback.apply(curr);
					next = (curr.right != null) ? curr.right : curr.parent;
				}
			} else if (prev == curr.left) {
				callback.apply(curr);
				next = (curr.right != null) ? curr.right : curr.parent;
			} else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}
