import java.util.*;

class Program {
	// O(nlog(n)) time | O(n) space
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
		Map<Integer, List<Integer>> durationToIndices = new HashMap<>();
		for (int idx = 0; idx < tasks.size(); idx++) {
			int duration = tasks.get(idx);
			if (!durationToIndices.containsKey(duration)) {
				durationToIndices.put(duration, new ArrayList<>());
			}
			durationToIndices.get(duration).add(idx);
		}
		List<Integer> sortedTasks = new ArrayList<>(tasks);
		Collections.sort(sortedTasks);
		ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
		int n = tasks.size();
		for (int idx = 0; idx < k; idx++) {
			int duration1 = sortedTasks.get(idx);
			int index1 = durationToIndices.get(duration1).remove(durationToIndices.get(duration1).size() - 1);
			int duration2 = sortedTasks.get(n - 1 - idx);
			int index2 = durationToIndices.get(duration2).remove(durationToIndices.get(duration2).size() - 1);
			ArrayList<Integer> pair = new ArrayList<>();
			pair.add(index1);
			pair.add(index2);
			pairedTasks.add(pair);
		}
    return pairedTasks;
  }
}
