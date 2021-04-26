import java.util.*;

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
