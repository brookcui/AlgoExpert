import java.util.*;

class Program {
	// O(v + e) time | O(v) space - where v is the number of vertices
	// and e is the number of edges in the graph
	public boolean cycleInGraph(int[][] edges) {
		// Write your code here.
		State[] states = new State[edges.length];
		for (int v = 0; v < edges.length; v++) {
			states[v] = State.TO_VISIT;
		}
		for (int v = 0; v < edges.length; v++) {
			boolean containsCycle = dfs(v, edges, states);
			if (containsCycle) {
				return true;
			}
		}
		return false;
	}

	private static boolean dfs(int node, int[][] edges, State[] states) {
		if (states[node].equals(State.VISITED)) {
			return false;
		}
		if (states[node].equals(State.VISITING)) {
			return true;
		}
		states[node] = State.VISITING;
		for (int neighbor : edges[node]) {
			boolean containsCycle = dfs(neighbor, edges, states);
			if (containsCycle) {
				return true;
			}
		}
		states[node] = State.VISITED;
		return false;
	}

	private static enum State {
		TO_VISIT, VISITING, VISITED;
	}
}
