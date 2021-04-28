import java.util.*;

class Program {
	// O(nlog(k) + k) time | O(n + k) space
  public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
    // Write your code here.
    List<Integer> sortedList = new ArrayList<Integer>();
		PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (int arrayIdx = 0; arrayIdx < arrays.size(); arrayIdx++) {
			if (arrays.get(arrayIdx).isEmpty()) {
				continue;
			}
			pq.add(new Triplet(arrayIdx, 0, arrays.get(arrayIdx).get(0)));
		}
		while (!pq.isEmpty()) {
			Triplet triplet = pq.poll();
			sortedList.add(triplet.value);
			if (triplet.elementIdx == arrays.get(triplet.arrayIdx).size() - 1) {
				continue;
			}
			pq.add(new Triplet(triplet.arrayIdx, triplet.elementIdx + 1, arrays.get(triplet.arrayIdx).get(triplet.elementIdx + 1)));
		}
		return sortedList;
  }
	
	static class Triplet {
		public int arrayIdx;
		public int elementIdx;
		public int value;
		
		public Triplet(int arrayIdx, int elementIdx, int value) {
			this.arrayIdx = arrayIdx;
			this.elementIdx = elementIdx;
			this.value = value;
		}
	}
}
