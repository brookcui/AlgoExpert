import java.util.*;

class Program {
	// O(k^n) time | O(n) space
  public int staircaseTraversal(int height, int maxSteps) {
    // Write your code here.
		if (maxSteps == 0) {
			return -1;
		}
    if (height <= 1) {
			return 1;
		}
		int numOfWays = 0;
		for (int step = 1; step <= Math.min(maxSteps, height); step++) {
			numOfWays += staircaseTraversal(height - step, maxSteps);
		}
		return numOfWays;
  }
}
