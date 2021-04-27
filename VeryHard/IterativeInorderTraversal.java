import java.util.function.Function;
import java.util.*;

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
