import java.util.*;

class Program {
	// O(v + e) time | O(v) space
  public boolean cycleInGraph(int[][] edges) {
    // Write your code here.
		State[] states = new State[edges.length];
		Arrays.fill(states, State.TO_VISIT);
		for (int vertex = 0; vertex < edges.length; vertex++) {
			if (states[vertex] == State.TO_VISIT) {
				if (dfs(vertex, edges, states)) {
					return true;
				}
			}
		}
    return false;
  }
	
	private enum State {
		TO_VISIT,
		VISITING,
		VISITED;
	}
	
	private boolean dfs(int vertex, int[][] edges, State[] states) {
		states[vertex] = State.VISITING;
		for (int neighbor : edges[vertex]) {
			State neighborState = states[neighbor];
			if (neighborState.equals(State.VISITING)) {
				return true;
			}
			if (neighborState.equals(State.VISITED)) {
				continue;
			}
			if (dfs(neighbor, edges, states)) {
				return true;
			}
		}
		states[vertex] = State.VISITED;
		return false;
	}
}
