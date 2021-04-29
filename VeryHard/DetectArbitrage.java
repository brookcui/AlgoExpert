import java.util.*;

class Program {
	// O(n^3) time | O(n^2) space
  public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
    // Write your code here.
		ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
    return findNegativeWeightCycle(logExchangeRates, 0);
  }
	
	private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
		ArrayList<ArrayList<Double>> logMatrix = new ArrayList<>();
		for (int row = 0; row < matrix.size(); row++) {
			logMatrix.add(new ArrayList<>());
			for (Double rate : matrix.get(row)) {
				logMatrix.get(row).add(-Math.log10(rate));
			}
		}
		return logMatrix;
	}
	
	private boolean findNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
		double[] distances = new double[graph.size()];
		Arrays.fill(distances, Double.MAX_VALUE);
		distances[start] = 0;
		for (int unused = 0; unused < graph.size(); unused++) {
			if (!updateDistances(graph, distances)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean updateDistances(ArrayList<ArrayList<Double>> graph, double[] distances) {
		boolean updated = false;
		for (int source = 0; source < graph.size(); source++) {
			for (int destination = 0; destination < graph.get(source).size(); destination++) {
				double newDistanceToDestionation = distances[source] + graph.get(source).get(destination);
				if (newDistanceToDestionation < distances[destination]) {
					distances[destination] = newDistanceToDestionation;
					updated = true;
				}
			}
		}
		return updated;
	}
}
