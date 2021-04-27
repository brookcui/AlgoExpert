import java.util.*;

class Program {
	// O(n) time | O(n) space
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    // Write your code here.
		if (root == null) {
			return null;
		}
		List<BinaryTree> inorderNodes = getInorderNodes(root, new ArrayList<>());
		for (int i = 0; i < inorderNodes.size() - 1; i++) {
			BinaryTree leftNode = inorderNodes.get(i);
			BinaryTree rightNode = inorderNodes.get(i + 1);
			leftNode.right = rightNode;
			rightNode.left = leftNode;
		}
    return inorderNodes.get(0);
  }
	
	private static List<BinaryTree> getInorderNodes(BinaryTree root, List<BinaryTree> inorderNodes) {
		if (root != null) {
			getInorderNodes(root.left, inorderNodes);
			inorderNodes.add(root);
			getInorderNodes(root.right, inorderNodes);
		}
		return inorderNodes;
	}

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
