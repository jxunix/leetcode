/*
 * Filename: IsomorphicStrings.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 12:36:23 PM CST
 */

public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		}

		if (s.equals("") && t.equals("")) {
			return true;
		} else if (s.equals("") || t.equals("")) {
			return false;
		}

		HashMap<Character, Character> stMap = new HashMap<Character, Character>();
		HashMap<Character, Character> dupMap = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			
			if (stMap.containsKey(cs)) {
				if (ct != stMap.get(cs)) {
					return false;
				}
			} else {
				if (dupMap.containsKey(ct)) {
					if (dupMap.get(ct) != cs) {
						return false;
					}
				} else {
					dupMap.put(ct, cs);
				}

				stMap.put(cs, ct);
			}
		}

		return true;
	}
}
