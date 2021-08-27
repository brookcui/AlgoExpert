import java.util.*;

class Program {
	// O(n) time | O(k) space - where n is the number of competitions and k is the number of teams
  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
		HashMap<String, Integer> scoreboard = new HashMap<>();
		for (int idx = 0; idx < results.size(); idx++) {
			ArrayList<String> competition = competitions.get(idx);
			int result = results.get(idx);
			if (result == 0) {
				String awayTeam = competition.get(1);
				scoreboard.put(awayTeam, 3 + scoreboard.getOrDefault(awayTeam, 0));
			} else if (result == 1) {
				String homeTeam = competition.get(0);
				scoreboard.put(homeTeam, 3 + scoreboard.getOrDefault(homeTeam, 0));
			}
		}
		String winnerCandidate = "Nobody";
		int maxScore = -1;
		for (Map.Entry<String, Integer> entry : scoreboard.entrySet()) {
			int score = entry.getValue();
			if (score > maxScore) {
				winnerCandidate = entry.getKey();
				maxScore = score;
			}
		}
    return winnerCandidate;
  }
}
