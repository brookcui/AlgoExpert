import java.util.*;

class Program {
	// O(n) time | O(1) space
	public int validStartingCity(int[] distances, int[] fuel, int mpg) {
		// Write your code here.
		int milesRemaining = 0;
		int indexOfStartingCityCandidate = 0;
		int milesRemainingAtStartingCityCandidate = 0;
		for (int cityIdx = 1; cityIdx < distances.length; cityIdx++) {
			int distanceFromPreviousCity = distances[cityIdx - 1];
			int fuelAdded = fuel[cityIdx - 1];
			milesRemaining += fuelAdded * mpg - distanceFromPreviousCity;
			if (milesRemaining < milesRemainingAtStartingCityCandidate) {
				milesRemainingAtStartingCityCandidate = milesRemaining;
				indexOfStartingCityCandidate = cityIdx;
			}
		}
		return indexOfStartingCityCandidate;
	}
}
