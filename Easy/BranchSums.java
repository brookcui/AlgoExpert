import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

	// O(n) time | O(log(n)) space - where n is the number of nodes in the binary tree
  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
    List<Integer> branchSums = new ArrayList<Integer>();
		helper(root, 0, branchSums);
		return branchSums;
  }
	
	private static void helper(BinaryTree root, int currSum, List<Integer> branchSums) {
		if (root == null) {
			return;
		} else {
			currSum += root.value;
			if (root.left == null && root.right == null) {
				branchSums.add(currSum);
			} else {
				helper(root.left, currSum, branchSums);
				helper(root.right, currSum, branchSums);
			}
		}
	}
}
