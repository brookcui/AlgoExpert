import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

	// O(m + n) time | O(1) space
  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    // Write your code here.
		LinkedList dummy = new LinkedList(-1);
		LinkedList prev = dummy;
		LinkedList p1 = headOne;
		LinkedList p2 = headTwo;
		while (p1 != null && p2 != null) {
			if (p1.value < p2.value) {
				prev.next = p1;
				p1 = p1.next;
			} else {
				prev.next = p2;
				p2 = p2.next;
			}
			prev = prev.next;
		}
		if (p1 == null) {
			prev.next = p2;
		} else {
			prev.next = p1;
		}
    return dummy.next;
  }
}
