import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
		if (tree == null) {
			return array;
		}
		BST curr = tree;
		Stack<BST> stack = new Stack<>();
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			array.add(curr.value);
			curr = curr.right;
		}
    return array;
  }

	// O(n) time | O(n) space
  public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
		if (tree == null) {
			return array;
		}
		Stack<BST> stack = new Stack<>();
		stack.add(tree);
		while (!stack.isEmpty()) {
			BST curr = stack.pop();
			array.add(curr.value);
			if (curr.right != null) {
				stack.add(curr.right);
			}
			if (curr.left != null) {
				stack.add(curr.left);
			}
		}
    return array;
  }

	// O(n) time | O(n) space
  public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
    // Write your code here.
		if (tree == null) {
			return array;
		}
		Stack<BST> stack = new Stack<>();
		stack.add(tree);
		BST prev = null;
		while (!stack.isEmpty()) {
			BST curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.add(curr.left);
				} else if (curr.right != null) {
					stack.add(curr.right);
				} else {
					stack.pop();
					array.add(curr.value);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.add(curr.right);
				} else {
					stack.pop();
					array.add(curr.value);
				}
			} else if (curr.right == prev) {
				stack.pop();
				array.add(curr.value);
			}
			prev = curr;
		}
    return array;
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
