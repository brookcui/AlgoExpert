import java.util.*;

// Solution 1
class Program {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
		int numOfVertices = edges.length;
		int[] minDistances = new int[numOfVertices];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		minDistances[start] = 0;
		Set<Integer> visited = new HashSet<>();
		while (visited.size() < numOfVertices) {
			int[] pair = getPairWithMinDistance(minDistances, visited);
			int vertex = pair[0];
			int minDist = pair[1];
			if (minDist == Integer.MAX_VALUE) {
				break;
			}
			visited.add(vertex);
			for (int[] edge : edges[vertex]) {
				int destination = edge[0];
				int distToDestination = edge[1];
				if (visited.contains(destination)) {
					continue;
				}
				int newDist = minDist + distToDestination;
				if (newDist < minDistances[destination]) {
					minDistances[destination] = newDist;
				}
			}
		}
		for (int i = 0; i < numOfVertices; i++) {
			if (minDistances[i] == Integer.MAX_VALUE) {
				minDistances[i] = -1;
			}
		}
    return minDistances;
  }
	
	private int[] getPairWithMinDistance(int[] distances, Set<Integer> visited) {
		int minDist = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < distances.length; i++) {
			if (visited.contains(i)) {
				continue;
			}
			int dist = distances[i];
			if (dist <= minDist) {
				vertex = i;
				minDist = dist;
			}
		}
		return new int[] {vertex, minDist};
	}
}

// Solution 2
class Program {
	// O((v + e) * log(v)) time | O(v) space - where v is the number of vertices and e is the number of edges
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
		int numOfVertices = edges.length;
		int[] minDistances = new int[numOfVertices];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		minDistances[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] - pair2[0]);
		pq.add(new int[]{start, 0});
		while (!pq.isEmpty()) {
			int[] pair = pq.poll();
			int vertex = pair[0];
			int minDist = pair[1];
			if (minDist == Integer.MAX_VALUE) {
				break;
			}
			for (int[] edge : edges[vertex]) {
				int destination = edge[0];
				int distToDestination = edge[1];
				int newDist = minDist + distToDestination;
				if (newDist < minDistances[destination]) {
					minDistances[destination] = newDist;
					pq.add(new int[]{destination, newDist});
				}
			}
		}
		for (int i = 0; i < numOfVertices; i++) {
			if (minDistances[i] == Integer.MAX_VALUE) {
				minDistances[i] = -1;
			}
		}
    return minDistances;
  }
}
