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

	private int visited;
	private int prevValue;

	// O(h + k) time | O(h) space
  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
		visited = 0;
		prevValue = -1;
		traverse(tree, k);
    return prevValue;
  }
	
	private void traverse(BST node, int k) {
		if (node == null || visited >= k) {
			return;
		}
		traverse(node.right, k);
		if (visited < k) {
			visited += 1;
			prevValue = node.value;
			traverse(node.left, k);
		}
	}
}
