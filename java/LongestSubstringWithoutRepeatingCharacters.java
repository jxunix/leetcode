/*
 * Filename: LongestSubstringWithoutRepeatingCharacters.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Tue 03 Mar 2015 12:36:06 PM EST
 */

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer c;

		int start = 0;
		int end = 0;
		int length = 0;

		for (; start != s.length(); start++) {
			c = new Integer(s.charAt(start));
			if (map.containsKey(c)) {
				if (length < start - end)
					length = start - end;
				int temp = map.get(c) + 1;
				end = temp > end ? temp : end;
				map.remove(c);
			}
			map.put(c, start);
		}

		if (length < start - end)
			length = start - end;

		return length;
	}
}
