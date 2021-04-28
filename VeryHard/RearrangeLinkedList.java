import java.util.*;

class Program {
	// O(n) time | O(1) space
  public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
    // Write your code here.
		LinkedList smallerHead = null, smallerTail = null;
		LinkedList equalHead = null, equalTail = null;
		LinkedList greaterHead = null, greaterTail = null;
		LinkedList curr = head;
		while (curr != null) {
			if (curr.value == k) {
				LinkedList[] equalList = growLinkedList(equalHead, equalTail, curr);
				equalHead = equalList[0];
				equalTail = equalList[1];
			} else if (curr.value < k) {
				LinkedList[] smallerList = growLinkedList(smallerHead, smallerTail, curr);
				smallerHead = smallerList[0];
				smallerTail = smallerList[1];
			} else {
				LinkedList[] greaterList = growLinkedList(greaterHead, greaterTail, curr);
				greaterHead = greaterList[0];
				greaterTail = greaterList[1];
			}
			LinkedList prev = curr;
			curr = curr.next;
			prev.next = null;
		}
		LinkedList[] smallerAndEqualList = connectLinkedLists(smallerHead, smallerTail, equalHead, equalTail);
		LinkedList[] rearrangedList = connectLinkedLists(smallerAndEqualList[0], smallerAndEqualList[1], greaterHead, greaterTail);
    return rearrangedList[0];
  }
	
	private static LinkedList[] growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
		LinkedList newHead = head, newTail = node;
		if (newHead == null) {
			newHead = node;
		}
		if (tail != null) {
			tail.next = node;
		}
		return new LinkedList[] {newHead, newTail};
	}
	
	private static LinkedList[] connectLinkedLists(LinkedList head1, LinkedList tail1, LinkedList head2, LinkedList tail2) {
		LinkedList newHead = head1 == null ? head2 : head1;
		LinkedList newTail = tail2 == null ? tail1 : tail2;
		if (tail1 != null) {
			tail1.next = head2;
		}
		return new LinkedList[] {newHead, newTail};
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
