/*
 * Filename: WordBreak.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 03 Jul 2015 09:58:52 AM EDT
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
		int n = s.length();

		List<String>[] lists = new ArrayList[n+1];
		lists[0] = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
		    if (lists[i] == null) {
		        continue;
		    }
		    
			for (String str : wordDict) {
				int j = i + str.length();

				if (j <= s.length() && str.equals(s.substring(i, j))) {
					if (lists[j] == null) {
						lists[j] = new ArrayList<String>();
					}

					lists[j].add(str);
				}
			}
		}

		List<String> res = new ArrayList<String>();
		if (lists[n] == null) {
			return res;
		}

		List<String> words = new ArrayList<String>();
		dfs(n, lists, res, words);
		return res;
	}

	private void dfs(int n, List<String>[] lists, List<String> res,
			List<String> words) {
		if (n == 0) {
			String sentence = "";

			for (String s : words) {
				sentence = s.concat(sentence);
				sentence = " ".concat(sentence);
			}

			res.add(sentence.substring(1));
			return;
		}

		for (String s : lists[n]) {
			words.add(s);
			dfs(n - s.length(), lists, res, words);
			words.remove(words.size() - 1);
		}
	}
}
