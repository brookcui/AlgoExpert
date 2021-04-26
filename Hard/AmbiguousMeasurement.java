import java.util.*;

class Program {
	// O(low * high * n) time | O(low * high) space - where n is the number of measuring cups
  public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
    // Write your code here.
    return canMeasure(measuringCups, low, high, new HashMap<>());
  }
	
	private boolean canMeasure(int[][] cups, int low, int high, Map<String, Boolean> memo) {
		String key = low + "," + high;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		if (low <= 0 && high <= 0) {
			return false;
		}
		boolean canMeasure = false;
		for (int[] cup : cups) {
			int cupLow = cup[0];
			int cupHigh = cup[1];
			if (low <= cupLow && cupHigh <= high) {
				canMeasure = true;
				break;
			}
			int newLow = Math.max(0, low - cupLow);
			int newHigh = Math.max(0, high - cupHigh);
			canMeasure = canMeasure(cups, newLow, newHigh, memo);
			if (canMeasure) {
				break;
			}
		}
		memo.put(key, canMeasure);
		return canMeasure;
	}
}
