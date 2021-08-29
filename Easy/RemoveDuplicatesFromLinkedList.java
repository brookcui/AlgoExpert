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

	// O(n) time | O(1) space - where n is the length of the original linked list
  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    // Write your code here.
		LinkedList curr = linkedList;
		while (curr != null && curr.next != null) {
			if (curr.value == curr.next.value) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
    return linkedList;
  }
}
