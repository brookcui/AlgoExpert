import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		LinkedList slow = head;
		LinkedList fast = head;
		while (k > 0) {
			if (fast == null) {
				return;
			}
			fast = fast.next;
			k--;
		}
		if (fast == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
