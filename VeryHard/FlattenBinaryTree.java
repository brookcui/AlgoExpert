import java.util.*;

// Solution 1
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

// Solution 2
class Program {
	// O(n) time | O(d) space
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    // Write your code here.
		if (root == null) {
			return null;
		}
		BinaryTree leftMost = flatten(root)[0];
		return leftMost;
  }
	
	private static BinaryTree[] flatten(BinaryTree node) {
		BinaryTree leftMost;
		BinaryTree rightMost;
		if (node.left == null) {
			leftMost = node;
		} else {
			BinaryTree[] leftAndRightMost = flatten(node.left);
			connectNodes(leftAndRightMost[1], node);
			leftMost = leftAndRightMost[0];
		}
		if (node.right == null) {
			rightMost = node;
		} else {
			BinaryTree[] leftAndRightMost = flatten(node.right);
			connectNodes(node, leftAndRightMost[0]);
			rightMost = leftAndRightMost[1];
		}
		return new BinaryTree[] {leftMost, rightMost};
	}

	private static void connectNodes(BinaryTree leftNode, BinaryTree rightNode) {
		leftNode.right = rightNode;
		rightNode.left = leftNode;
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
