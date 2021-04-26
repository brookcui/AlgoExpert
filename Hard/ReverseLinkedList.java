import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
		LinkedList curr = head, prev = null;
		while (curr != null) {
			LinkedList next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
    return prev;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
