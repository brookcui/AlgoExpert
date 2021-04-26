import java.util.*;

// Solution 1
class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

	// O(n^2) time | O(n) space
  public BST reconstructBst(List<Integer> preOrderTraversalValues) {
    // Write your code here.
		if (preOrderTraversalValues.size() == 0) {
			return null;
		}
		int value = preOrderTraversalValues.get(0); // pivot value
		int rightSubtreeRootIdx = preOrderTraversalValues.size();
		for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
			if (preOrderTraversalValues.get(idx) >= value) {
				rightSubtreeRootIdx = idx;
				break;
			}
		}
		BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
		BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));
		BST bst = new BST(value);
		bst.left = leftSubtree;
		bst.right = rightSubtree;
    return bst;
  }
}

// Solution 2
class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

	// O(n) time | O(n) space
  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    // Write your code here.
		if (preOrderTraversalValues.size() == 0) {
			return null;
		}
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, new int[] {0});
  }
	
	private BST helper(int lower, int upper, List<Integer> values, int[] rootIdx) {
		if (rootIdx[0] == values.size()) {
			return null;
		}
		int rootValue = values.get(rootIdx[0]);
		if (rootValue < lower || rootValue >= upper) {
			return null;
		}
		rootIdx[0] += 1;
		BST leftSubtree = helper(lower, rootValue, values, rootIdx);
		BST rightSubtree = helper(rootValue, upper, values, rootIdx);
		BST bst = new BST(rootValue);
		bst.left = leftSubtree;
		bst.right = rightSubtree;
		return bst;
	}
}
