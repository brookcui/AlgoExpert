import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public int lineThroughPoints(int[][] points) {
    // Write your code here.
		if (points.length == 0) {
			return 0;
		}
		int maxPointsThroughLine = 1;
		for (int i = 0; i < points.length - 1; i++) {
			int[] p1 = points[i];
			Map<String, Integer> slopesMap = new HashMap<>();
			for (int j = i + 1; j < points.length; j++) {
				int[] p2 = points[j];
				int[] slope = getSlope(p1, p2);
				String slopeKey = formatSlope(slope);
				slopesMap.put(slopeKey, slopesMap.getOrDefault(slopeKey, 1) + 1);
			}
			for (int number : slopesMap.values()) {
				maxPointsThroughLine = Math.max(maxPointsThroughLine, number);
			}
		}
    return maxPointsThroughLine;
  }
	
	private static int[] getSlope(int[] p1, int[] p2) {
		int[] slope = new int[] {0, 1}; // slope of a vertical line
		if (p1[0] != p2[0]) { // not vertical line
			int xDiff = p1[0] - p2[0];
			int yDiff = p1[1] - p2[1];
			int gcd = gcd(Math.abs(xDiff), Math.abs(yDiff));
			xDiff /= gcd;
			yDiff /= gcd;
			if (xDiff < 0) {
				xDiff *= -1;
				yDiff *= -1;
			}
			slope = new int[] {xDiff, yDiff};
		}
		return slope;
	}
	
	private static int gcd(int a, int b) {
		while (true) {
			if (a == 0) {
				return b;
			}
			if (b == 0) {
				return a;
			}
			int tmp = a;
			a = b;
			b = tmp % b;
		}
	}
	
	private static String formatSlope(int[] slope) {
		return slope[0] + "," + slope[1];
	}
}
