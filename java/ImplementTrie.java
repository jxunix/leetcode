/*
 * Filename: ImplementTrie.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 07 Jul 2015 04:55:11 PM EDT
 */

class TrieNode {
	char c;
	boolean isLeaf;
	TrieNode[] children;

	// Initialize your data structure here.
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

	// Inserts a word into the trie.
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

	// Returns if the word is in the trie.
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

	// Returns if there is any word in the trie
	// that starts with the given prefix.
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

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
