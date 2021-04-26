import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
		if (head == null || head.next == null) {
			return null;
		}
		LinkedList slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
    return slow;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
