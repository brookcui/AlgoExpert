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

	// O(max(m,n)) time | O(max(m,n)) space
  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    // Write your code here.
		LinkedList dummy = new LinkedList(-1);
		LinkedList curr = dummy;
		int carry = 0;
		LinkedList p1 = linkedListOne;
		LinkedList p2 = linkedListTwo;
		while (p1 != null || p2 != null || carry != 0) {
			int value1 = (p1 != null) ? p1.value : 0;
			int value2 = (p2 != null) ? p2.value : 0;
			int sum = value1 + value2 + carry;
			LinkedList newNode = new LinkedList(sum % 10);
			curr.next = newNode;
			curr = newNode;
			carry = sum / 10;
			p1 = (p1 != null) ? p1.next : null;
			p2 = (p2 != null) ? p2.next : null;
		}
    return dummy.next;
  }
}
