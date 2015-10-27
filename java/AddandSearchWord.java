/*
 * Filename: AddandSearchWord.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 15 Jul 2015 08:52:16 PM EDT
 */

public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return searchAux(word, 0, root);
	}

	private boolean searchAux(String word, int i, TrieNode p) {
		if (p == null) {
			return false;
		}

		if (i == word.length()) {
			return p.isLeaf;
		}

		char c = word.charAt(i);

		if (c == '.') {
			for (int j = 0; j < 26; j++) {
				if (searchAux(word, i+1, p.children[j])) {
					return true;
				}
			}

			return false;
		} else {
			return searchAux(word, i+1, p.children[c - 'a']);
		}
	}
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

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
