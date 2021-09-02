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

    // O(n) time | O(n) space
    public List<String> breadthFirstSearch(List<String> array) {
      // Write your code here.
      Queue<Node> queue = new LinkedList<>();
      queue.add(this);
      while (!queue.isEmpty()) {
        Node node = queue.poll();
        array.add(node.name);
        queue.addAll(node.children);
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
