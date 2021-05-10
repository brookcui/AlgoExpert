import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

		// O(v + e) time | O(v) space
    public List<String> breadthFirstSearch(List<String> array) {
      // Write your code here.
			Queue<Node> queue = new LinkedList<>();
			queue.add(this);
			while (!queue.isEmpty()) {
				Node curr = queue.poll();
				array.add(curr.name);
				queue.addAll(curr.children);
			}
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
