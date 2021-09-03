import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
	public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
		// Write your code here.
		ArrayList<ArrayList<Integer>> assignedPairs = new ArrayList<>();
		Map<Integer, List<Integer>> durationsToIndices = buildMapFromDurationsToIndices(tasks);
		Collections.sort(tasks);
		for (int l = 0, r = tasks.size() - 1; l < r; l++, r--) {
			int duration1 = tasks.get(l);
			int index1 = durationsToIndices.get(duration1).remove(0);
			int duration2 = tasks.get(r);
			int index2 = durationsToIndices.get(duration2).remove(0);
			List<Integer> pair = List.of(index1, index2);
			assignedPairs.add(new ArrayList<>(pair));
		}
		return assignedPairs;
	}

	private static Map<Integer, List<Integer>> buildMapFromDurationsToIndices(ArrayList<Integer> tasks) {
		Map<Integer, List<Integer>> durationsToIndices = new HashMap<>();
		for (int idx = 0; idx < tasks.size(); idx++) {
			int duration = tasks.get(idx);
			durationsToIndices.computeIfAbsent(duration, indices -> new ArrayList<>()).add(idx);
		}
		return durationsToIndices;
	}
}
