/*
 * Filename: WordBreak.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 03 Jul 2015 09:58:52 AM EDT
 */

public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] test = new boolean[s.length() + 1];
		test[0] = true;

		for (int i = 1; i < test.length; i++) {
			for (int j = 0; j < i; j++) {
				test[i] |= test[j] && wordDict.contains(s.substring(j, i));
			}
		}

		return test[test.length - 1];
	}
}
