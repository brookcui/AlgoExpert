import java.util.*;

class Program {
	// O(nlog(n)) time | O(1) space - where n is the number of tandem bicycle
  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    // Write your code here.
		int n = redShirtSpeeds.length;
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		if (fastest) {
			int maxTotalSpeed = 0;
			int l = n - 1, r = n - 1;
			for (int i = 0; i < n; i++) {
				if (redShirtSpeeds[l] >= blueShirtSpeeds[r]) {
					maxTotalSpeed += redShirtSpeeds[l];
					--l;
				} else {
					maxTotalSpeed += blueShirtSpeeds[r];
					--r;
				}
			}
			return maxTotalSpeed;
		} else {
			int minTotalSpeed = 0;
			for (int i = 0; i < n; i++) {
				minTotalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
			}
			return minTotalSpeed;
		}
  }
}
