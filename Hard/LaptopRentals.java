import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
		if (times.size() == 0) {
			return 0;
		}
		Collections.sort(times, (a, b) -> Integer.compare(a.get(0), b.get(0)));
		PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(1), b.get(1)));
		pq.add(times.get(0));
		for (int i = 1; i < times.size(); i++) {
			ArrayList<Integer> interval = times.get(i);
			if (pq.peek().get(1) <= interval.get(0)) {
				pq.poll();
			}
			pq.add(interval);
		}
    return pq.size();
  }
}
