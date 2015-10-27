/*
 * Filename: WordLadder.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 03:31:57 PM EDT
 */

public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> length = new LinkedList<Integer>();

		wordDict.add(endWord);
		queue.add(beginWord);
		length.add(1);

		while (!queue.isEmpty()) {
			String s = queue.poll();
			int len = length.poll();

			if (s.equals(endWord)) {
				return len;
			}

			for (int i = 0; i < s.length(); i++) {
				char[] arr = s.toCharArray();

				for (char c = 'a'; c <= 'z'; c++) {
					arr[i] = c;
					String str = new String(arr);

					if (wordDict.contains(str)) {
						queue.add(str);
						length.add(len + 1);
						wordDict.remove(str);
					}
				}
			}
		}

		return 0;
	}
}
