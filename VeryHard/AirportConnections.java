import java.util.*;

class Program {
	// O(a * (a + r) + a + r + alog(a)) time | O(a + r) space
  public static int airportConnections(
      List<String> airports, List<List<String>> routes, String startingAirport) {
    // Write your code here.
		Map<String, List<String>> graph = buildGraph(airports, routes);
		Set<String> reachableVertices = new HashSet<>();
		List<String> unreachableNodes = getUnreachableNodes(graph, airports, startingAirport, reachableVertices);
		Map<String, List<String>> unreachableGraph = getUnreachableGraph(graph, unreachableNodes, reachableVertices);
    return getMinNumberOfNewConnections(unreachableGraph, unreachableNodes, reachableVertices);
  }
	
	// O(v + e) time | O(v + e) space
	private static Map<String, List<String>> buildGraph(List<String> vertices, List<List<String>> edges) {
		Map<String, List<String>> graph = new HashMap<>();
		for (String vertex : vertices) {
			graph.put(vertex, new ArrayList<>());
		}
		for (List<String> edge : edges) {
			graph.get(edge.get(0)).add(edge.get(1));
		}
		return graph;
	}
	
	// O(v + e) time | O(v) space
	private static List<String> getUnreachableNodes(Map<String, List<String>> graph, List<String> vertices, String start, Set<String> reachableVertices) {
		dfs(graph, start, reachableVertices);
		List<String> unreachableNodes = new ArrayList<>();
		for (String vertex : vertices) {
			if (reachableVertices.contains(vertex)) {
				continue;
			}
			unreachableNodes.add(vertex);
		}
		return unreachableNodes;
	}
	
	private static void dfs(Map<String, List<String>> graph, String vertex, Set<String> visited) {
		if (visited.contains(vertex)) {
			return;
		}
		visited.add(vertex);
		for (String neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
			dfs(graph, neighbor, visited);
		}
	}
	
	// O(v * (v + e)) time | O(e) space
	private static Map<String, List<String>> getUnreachableGraph(Map<String, List<String>> graph, List<String> unreachableNodes, Set<String> reachableVertices) {
		Map<String, List<String>> unreachableGraph = new HashMap<>();
		for (String vertex : unreachableNodes) {
			List<String> connectedVertices = new ArrayList<>();
			dfsUnreachableNodes(graph, vertex, reachableVertices, new HashSet<>(), connectedVertices);
			unreachableGraph.put(vertex, connectedVertices);
		}
		return unreachableGraph;
	}
	
	private static void dfsUnreachableNodes(Map<String, List<String>> graph, String vertex, Set<String> reachableVertices, Set<String> visited, List<String> connectedVertices) {
		if (reachableVertices.contains(vertex) || visited.contains(vertex)) {
			return;
		}
		visited.add(vertex);
		connectedVertices.add(vertex);
		for (String neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
			dfsUnreachableNodes(graph, neighbor, reachableVertices, visited, connectedVertices);
		}
	}
	
	// O(vlog(v) (v + e)) time | O(1) space
	private static int getMinNumberOfNewConnections(Map<String, List<String>> unreachableGraph, List<String> unreachableNodes, Set<String> reachableVertices) {
		unreachableNodes.sort((a, b) -> unreachableGraph.get(b).size() - unreachableGraph.get(a).size());
		int numOfNewConnections = 0;
		for (String vertex : unreachableNodes) {
			if (reachableVertices.contains(vertex)) {
				continue;
			}
			numOfNewConnections++;
			for (String nei : unreachableGraph.get(vertex)) {
				reachableVertices.add(nei);
			}
		}
		return numOfNewConnections;
	}
}
