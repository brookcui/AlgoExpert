import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

	// O(n) time | O(n) space
  public boolean linkedListPalindrome(LinkedList head) {
    // Write your code here.
    return isPalindrome(head, head).first;
  }
	
	private Pair<Boolean, LinkedList> isPalindrome(LinkedList leftNode, LinkedList rightNode) {
		if (rightNode == null) {
			return new Pair<>(true, leftNode);
		}
		Pair<Boolean, LinkedList> pairInfo = isPalindrome(leftNode, rightNode.next);
		boolean outerNodesAreEqual = pairInfo.first;
		LinkedList leftNodeToCompare = pairInfo.second;
		boolean recursiveIsEqual = outerNodesAreEqual && (leftNodeToCompare.value == rightNode.value);
		LinkedList nextLeftNodeToCompare = leftNodeToCompare.next;
		return new Pair<>(recursiveIsEqual, nextLeftNodeToCompare);
	}
	
	class Pair<U, V> {
		public U first;
		public V second;
		
		public Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}
}
