import java.util.*;

class Program {
	// O(n) time | O(1) space - where n is the number of nodes in the linked list
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    // Write your code here.
		if (head == null) {
			return null;
		}
		int length = 1;
		LinkedList tail = head;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		int offset = Math.abs(k) % length;
		if (offset == 0) {
			return head;
		}
		int newTailIndex = (k > 0) ? length - offset : offset;
		LinkedList newTail = head;
		for (int i = 1; i < newTailIndex; i++) {
			newTail = newTail.next;
		}
		LinkedList newHead = newTail.next;
		newTail.next = null;
		tail.next = head;
    return newHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}

