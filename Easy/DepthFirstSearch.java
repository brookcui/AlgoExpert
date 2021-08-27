import java.util.*;

class Program {
  // Do not edit the class below except
  // for the depthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

		// O(n) time | O(n) space - where n is the number of nodes in the tree
    public List<String> depthFirstSearch(List<String> array) {
      // Write your code here.
			array.add(name);
			for (Node child : children) {
				child.depthFirstSearch(array);
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
