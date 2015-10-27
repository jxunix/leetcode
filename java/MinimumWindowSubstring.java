/*
 * Filename: MinimumWindowSubstring.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 20 May 2015 07:07:31 PM EDT
 */

public class Solution {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);

			if (!dict.containsKey(c)) {
				dict.put(c, 1);
			} else {
				dict.put(c, dict.get(c) + 1);
			}
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int size = 0;
		int stt = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		String res = "";

		while (end < s.length()) {
			char c = s.charAt(end);
			
			if (dict.containsKey(c)) {
				if (map.containsKey(c)) {
					if (map.get(c) < dict.get(c)) {
						size++;
					}

					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					size++;
				}
			}

			if (size == t.length()) {
				char sc = s.charAt(stt);

				while (!map.containsKey(sc) || map.get(sc) > dict.get(sc)) {
					if (map.containsKey(sc) && map.get(sc) > dict.get(sc)) {
						map.put(sc, map.get(sc) - 1);
					}

					stt++;
					sc = s.charAt(stt);
				}

				if (end - stt + 1 < min) {
					res = s.substring(stt, end + 1);
					min = end - stt + 1;
				}
			}

			end++;
		}

		return res;
	}
}
