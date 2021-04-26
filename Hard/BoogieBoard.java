import java.util.*;

class Program {
	// O(mn*8^s + ws) time | O(mn + ws) space - where m is the height of the board,
	// n is the width of the board, w is the contained words size, s is the maximum
	// length of contained words
  public static List<String> boggleBoard(char[][] board, String[] words) {
    // Write your code here.
		Trie trie = new Trie();
		for (String word : words) {
			trie.add(word);
		}
		Set<String> containedWords = new HashSet<>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(i, j, board, trie, visited, containedWords);
			}
		}
    return new ArrayList<>(containedWords);
  }
	
	private static void dfs(int r, int c, char[][] board, Trie trieNode, boolean[][] visited, Set<String> containedWords) {
		if (visited[r][c]) {
			return;
		}
		char letter = board[r][c];
		if (!trieNode.children.containsKey(letter)) {
			return;
		}
		visited[r][c] = true;
		trieNode = trieNode.children.get(letter);
		if (!trieNode.word.equals("")) {
			containedWords.add(trieNode.word);
		}
		List<int[]> neighbors = getNeighbors(board, r, c);
		for (int[] neighbor : neighbors) {
			dfs(neighbor[0], neighbor[1], board, trieNode, visited, containedWords);
		}
		visited[r][c] = false;
	}
	
	private static List<int[]> getNeighbors(char[][] board, int r, int c) {
		List<int[]> neighbors = new ArrayList<>();
		int m = board.length, n = board[0].length;
		if (r < 0 || r >= m || c < 0 || c >= n) {
			return neighbors;
		}
		if (r - 1 >= 0) {
			neighbors.add(new int[] {r - 1, c});
			if (c - 1 >= 0) {
				neighbors.add(new int[] {r - 1, c - 1});
			}
			if (c + 1 < n) {
				neighbors.add(new int[] {r - 1, c + 1});
			}
		}
		if (r + 1 < m) {
			neighbors.add(new int[] {r + 1, c});
			if (c - 1 >= 0) {
				neighbors.add(new int[] {r + 1, c - 1});
			}
			if (c + 1 < n) {
				neighbors.add(new int[] {r + 1, c + 1});
			}
		}
		if (c - 1 >= 0) {
			neighbors.add(new int[] {r, c - 1});
		}
		if (c + 1 < n) {
			neighbors.add(new int[] {r, c + 1});
		}
		return neighbors;
	}
	
	static class Trie {
		Map<Character, Trie> children;
		String word;
		
		public Trie() {
			this.children = new HashMap<>();
			this.word = "";
		}
		
		public void add(String str) {
			Trie node = this;
			for (int i = 0; i < str.length(); i++) {
				char letter = str.charAt(i);
				if (!node.children.containsKey(letter)) {
					Trie newNode = new Trie();
					node.children.put(letter, newNode);
				}
				node = node.children.get(letter);
			}
			node.word = str;
		}
	}
}
