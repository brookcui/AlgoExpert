import java.util.*;

class Program {
	// O(nlogn) time | O(1) space - where n is the number of coins
  public int nonConstructibleChange(int[] coins) {
    // Write your code here.
		Arrays.sort(coins);
		int lastConstructibleChange = 0;
		for (int coin: coins) {
			if (coin > lastConstructibleChange + 1) {
				return lastConstructibleChange + 1;
			}
			lastConstructibleChange += coin;
		}
    return lastConstructibleChange + 1;
  }
}
