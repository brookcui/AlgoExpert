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

	// O(n) time | O(1) space
  public LinkedList nodeSwap(LinkedList head) {
    // Write your code here.
		if (head == null || head.next == null) {
			return head;
		}
		LinkedList dummy = new LinkedList(-1);
		dummy.next = head;
		LinkedList prev = dummy;
		while (prev.next != null && prev.next.next != null) {
			LinkedList first = prev.next;
			LinkedList second = prev.next.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			prev = first;
		}
    return dummy.next;
  }
}
