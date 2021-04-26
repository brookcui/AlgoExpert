import java.util.*;

class Program {
	// O((2n)!/((n!(n+1)!))) time | O((2n)!/((n!(n+1)!))) space
  public ArrayList<String> generateDivTags(int numberOfTags) {
    // Write your code here.
		ArrayList<String> validDivTags = new ArrayList<>();
		dfs(numberOfTags, numberOfTags, "", validDivTags);
    return validDivTags;
  }
	
	private static void dfs(int opening, int closed, String prefix, ArrayList<String> validDivTags) {
		if (opening > 0) {
			dfs(opening - 1, closed, prefix + "<div>", validDivTags);
		}
		if (opening < closed) {
			dfs(opening, closed - 1, prefix + "</div>", validDivTags);
		}
		if (closed == 0) {
			validDivTags.add(prefix);
		}
	}
}
