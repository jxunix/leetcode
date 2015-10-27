/*
 * Filename: WordSearchII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 12:13:20 PM EDT
 */

public class Solution {
	Set<String> res = new HashSet<String>(); 

	public List<String> findWords(char[][] board, String[] words) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return new ArrayList<String>();
		}

		if (words == null || words.length == 0) {
			return new ArrayList<String>();
		}

		Trie trie = new Trie();
		for (String word: words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visited, "", i, j, trie);
			}
		}

		return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (visited[i][j]) {
			return;
		}

		str = str + board[i][j];

		if (!trie.startsWith(str)) {
			return;
		}

		if (trie.search(str)) {
			res.add(str);
		}

		visited[i][j] = true;
		dfs(board, visited, str, i-1, j, trie);
		dfs(board, visited, str, i+1, j, trie);
		dfs(board, visited, str, i, j-1, trie);
		dfs(board, visited, str, i, j+1, trie);
		visited[i][j] = false;
	}

	class TrieNode {
		char c;
		boolean isLeaf;
		TrieNode[] children;

		public TrieNode() {
			this.children = new TrieNode[26];
		}

		public TrieNode(char c) {
			this.c = c;
			this.children = new TrieNode[26];
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode p = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				if (p.children[c - 'a'] == null) {
					p.children[c - 'a'] = new TrieNode(c);
				}

				p = p.children[c - 'a'];
			}

			p.isLeaf = true;
		}

		public boolean search(String word) {
			TrieNode p = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				p = p.children[c - 'a'];

				if (p == null) {
					return false;
				}
			}

			return p.isLeaf;
		}

		public boolean startsWith(String prefix) {
			TrieNode p = root;

			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				p = p.children[c - 'a'];

				if (p == null) {
					return false;
				}
			}

			return true;
		}
	}
}
