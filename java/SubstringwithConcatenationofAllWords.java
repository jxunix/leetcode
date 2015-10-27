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
				map.put(L[i], map.get(L[i]) + 1);
			} else {
				map.put(L[i], 1);
			}
		}

		int l = S.length();
		int m = L.length;
		int n = L[0].length();

		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i <= l - m*n; i++) {
			if (match(S.substring(i, i+m*n), map, m, n)) {
				ret.add(i);
			}
		}

		return ret;
	}

	private boolean match(String S, HashMap<String, Integer> map, int m, int n) {
		HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);

		int wordCnt = S.length() / n;
		String substr;

		for (int i = 0; i < wordCnt; i++) {
			substr = S.substring(i*n, (i+1)*n);
			if (map2.containsKey(substr)) {
				if (map2.get(substr) > 1) {
					map2.put(substr, map2.get(substr) - 1);
				} else {
					map2.remove(substr);
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
