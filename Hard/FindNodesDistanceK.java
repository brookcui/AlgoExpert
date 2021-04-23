import java.util.*;

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

	// O(n) time | O(n) space
  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    // Write your code here.
		BinaryTree targetNode = searchForNode(tree, target);
		Map<Integer, BinaryTree> nodeToParent = new HashMap<>();
		populateNodeToParent(tree, nodeToParent, null);
		return searchNodesDistanceK(targetNode, nodeToParent, k);
  }
	
	private void populateNodeToParent(BinaryTree node, Map<Integer, BinaryTree> nodeToParent, BinaryTree parent) {
		if (node != null) {
			nodeToParent.put(node.value, parent);
			populateNodeToParent(node.left, nodeToParent, node);
			populateNodeToParent(node.right, nodeToParent, node);
		}
	}
	
	private BinaryTree searchForNode(BinaryTree node, int value) {
		if (node == null) {
			return null;
		}
		if (node.value == value) {
			return node;
		}
		BinaryTree left = searchForNode(node.left, value);
		if (left != null) {
			return left;
		}
		BinaryTree right = searchForNode(node.right, value);
		if (right != null) {
			return right;
		}
		return null;
	}
	
	private static class Pair<U, V> {
		final U first;
		final V second;
		
		Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}
	
	private ArrayList<Integer> searchNodesDistanceK(BinaryTree targetNode, Map<Integer, BinaryTree> nodeToParent, int k) {
		if (targetNode == null) {
			return new ArrayList<>();
		}
		Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<>();
		Set<BinaryTree> seen = new HashSet<>();
		queue.add(new Pair<>(targetNode, 0));
		seen.add(targetNode);
		while (!queue.isEmpty()) {
			Pair<BinaryTree, Integer> pair = queue.poll();
			BinaryTree node = pair.first;
			int distance = pair.second;
			if (distance == k) {
				ArrayList<Integer> nodeDistanceK = new ArrayList<>();
				nodeDistanceK.add(node.value);
				for (Pair<BinaryTree, Integer> p : queue) {
					nodeDistanceK.add(p.first.value);
				}
				return nodeDistanceK;
			}
			List<BinaryTree> neighbors = new ArrayList<>();
			neighbors.add(node.left);
			neighbors.add(node.right);
			neighbors.add(nodeToParent.get(node.value));
			for (BinaryTree nei : neighbors) {
				if (nei == null || seen.contains(nei)) {
					continue;
				}
				seen.add(nei);
				queue.add(new Pair<>(nei, distance + 1));
			}
		}
		return new ArrayList<>();
	}
}
