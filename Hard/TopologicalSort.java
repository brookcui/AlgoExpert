import java.util.*;

class Program {
	// O(j + d) time | O(j + d) space
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    // Write your code here.
		Map<Integer, List<Integer>> graph = buildGraph(deps);
		Map<Integer, State> statesMap = buildStatesMap(jobs);
		List<Integer> order = new ArrayList<Integer>();
		for (int vertex : jobs) {
			if (statesMap.get(vertex).equals(State.TO_VISIT) && !dfs(order, vertex, graph, statesMap)) {
				return new ArrayList<>();
			}
		}
    return order; 
  }

	private static Map<Integer, List<Integer>> buildGraph(List<Integer[]> edges) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (Integer[] edge: edges) {
			int start = edge[0];
			int end = edge[1];
			graph.putIfAbsent(start, new ArrayList<>());
			graph.get(start).add(end);
		}
		return graph;
	}
	
	private enum State {
		TO_VISIT,
		VISITING,
		VISITED;
	}
	
	private static Map<Integer, State> buildStatesMap(List<Integer> jobs) {
		Map<Integer, State> statesMap = new HashMap<>();
		for (int vertex : jobs) {
			statesMap.put(vertex, State.TO_VISIT);
		}
		return statesMap;
	}

	private static boolean dfs(List<Integer> order, int vertex, Map<Integer, List<Integer>> graph, Map<Integer, State> statesMap) {
		statesMap.put(vertex, State.VISITING);
		if (graph.containsKey(vertex)) {
			for (int nei : graph.get(vertex)) {
				if (statesMap.get(nei).equals(State.VISITED)) {
					continue;
				}
				if (statesMap.get(nei).equals(State.VISITING)) {
					return false;
				}
				if (!dfs(order, nei, graph, statesMap)) {
					return false;
				}
			}
		}
		statesMap.put(vertex, State.VISITED);
		order.add(0, vertex);
		return true;
	}
}
