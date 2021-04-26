import java.util.*;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
  static class ContinuousMedianHandler {
    double median = 0;
		private PriorityQueue<Integer> smaller = new PriorityQueue<>();
		private PriorityQueue<Integer> larger = new PriorityQueue<>();
		
		// O(log(n)) time | O(n) space
    public void insert(int number) {
      // Write your code here.
			if (smaller.size() == 0 || number < -smaller.peek()) {
				smaller.add(-number);
			} else {
				larger.add(number);
			}
			// rebalance heaps
			if (smaller.size() - larger.size() == 2) {
				larger.add(-smaller.poll());
			} else if (larger.size() - smaller.size() == 2) {
				smaller.add(-larger.poll());
			}
			// update median
			if (smaller.size() == larger.size()) {
				median = ((double) -smaller.peek() + (double) larger.peek()) / 2;
			} else if (smaller.size() > larger.size()) {
				median = -smaller.peek();
			} else {
				median = larger.peek();
			}
    }

    public double getMedian() {
      return median;
    }
  }
}
