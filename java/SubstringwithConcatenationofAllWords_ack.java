/*
 * Filename: SubstringwithConcatenationofAllWords.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 10:36:38 PM EDT
 */

public class Solution {
	public List<Integer> findSubstring(String S, String[] L) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (map.containsKey(L[i])) {
				map.put(L[i], map.get(L[i])+1);
			} else {
				map.put(L[i], 1);
			}
		}

		int l = S.length();
		int m = L.length;
		int n = L[0].length();

		int head = 0;
		int tail = 0;

		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < l; i++) {
			if (!map.containsKey(S.substring(i, Math.min(i+n, l)))) {
				continue;
			}

			int j = i;
			while (j < l && map.containsKey(S.substring(j, Math.min(j+n, l)))) {
				j += n;
			}

			if (match(S.substring(i, j), map, m, n)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private boolean match(String S, HashMap<String, Integer> map, int m, int n) {
		if (S.length() < m*n) {
			return false;
		}

		HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);

		int wordCnt = S.length() / n;
		for (int i = 0; i < wordCnt; i++) {
			String sub = S.substring(i*n, Math.min((i+1)*n, S.length()));
			if (map2.containsKey(sub)) {
				if (map2.get(sub) == 1) {
					map2.remove(sub);
				} else {
					map2.put(sub, map2.get(sub)-1);
				}
			} else {
				break;
			}
		}

		if (map2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
