/*
 * Filename: RepeatedDNASequences.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 15 Jul 2015 10:23:33 PM EDT
 */

public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();

		if (s.length() <= 10) {
			return res;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		HashMap<Integer, Integer> dupMap = new HashMap<Integer, Integer>();

		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < 9) {
				hash = (hash << 2) + map.get(s.charAt(i));
			} else {
				hash = (hash << 2) + map.get(s.charAt(i));
				hash = hash & (1 << 20) - 1;

				if (dupMap.containsKey(hash)) {
					if (dupMap.get(hash) == 1) {
						res.add(s.substring(i-9, i+1));
						dupMap.put(hash, 2);
					}
				} else {
					dupMap.put(hash, 1);
				}
			}
		}

		return res;
	}
}
