import java.util.*;

// Solution 1
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

// Solution 2
class Program {
	// O(nlog(n)) time | O(n) space
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
		if (times.size() == 0) {
			return 0;
		}
		int used = 0;
		List<Integer> starts = new ArrayList<>();
		List<Integer> ends = new ArrayList<>();
		for (ArrayList<Integer> interval : times) {
			starts.add(interval.get(0));
			ends.add(interval.get(1));
		}
		Collections.sort(starts);
		Collections.sort(ends);
		int startIterator = 0;
		int endIterator = 0;
		while (startIterator < times.size()) {
			if (starts.get(startIterator) >= ends.get(endIterator)) {
				used--;
				endIterator++;
			}
			used++;
			startIterator++;
		}
    return used;
  }
}
