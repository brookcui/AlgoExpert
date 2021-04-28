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
  public LinkedList zipLinkedList(LinkedList linkedList) {
    // Write your code here.
		if (linkedList == null || linkedList.next == null) {
			return linkedList;
		}
		LinkedList firstHalf = linkedList;
		LinkedList secondHalf = splitLinkedListEvenly(linkedList);
		LinkedList reversedSecondHalf = reverseLinkedList(secondHalf);
    return interweaveLinkedLists(firstHalf, reversedSecondHalf);
  }
	
	private LinkedList splitLinkedListEvenly(LinkedList linkedList) {
		LinkedList slow = linkedList;
		LinkedList fast = linkedList;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedList secondHalfHead = slow.next;
		slow.next = null;
		return secondHalfHead;
	}
	
	private LinkedList reverseLinkedList(LinkedList linkedList) {
		LinkedList prev = null;
		LinkedList curr = linkedList;
		while (curr != null) {
			LinkedList next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	private LinkedList interweaveLinkedLists(LinkedList firstHead, LinkedList secondHead) {
		LinkedList p1 = firstHead;
		LinkedList p2 = secondHead;
		while (p1 != null && p2 != null) {
			LinkedList p1Next = p1.next;
			LinkedList p2Next = p2.next;
			p1.next = p2;
			p2.next = p1Next;
			p1 = p1Next;
			p2 = p2Next;
		}
		return firstHead;
	}
}
