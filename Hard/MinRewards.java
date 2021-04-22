import java.util.*;

class Program {
	// O(n^2) time | O(n) space
  public static int minRewards(int[] scores) {
    // Write your code here.
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		for (int i = 1; i < scores.length; i++) {
			int j = i - 1;
			if (scores[i] > scores[j]) {
				rewards[i] = rewards[j] + 1;
			} else {
				while (j >= 0 && scores[j] > scores[j+1]) {
					rewards[j] = Math.max(rewards[j], rewards[j+1] + 1);
					j--;
				}
			}
		}
		int minRewards = 0;
		for (int reward : rewards) {
			minRewards += reward;
		}
		return minRewards;
  }
}
