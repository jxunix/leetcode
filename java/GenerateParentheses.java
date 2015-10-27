/*
 * Filename: GenerateParentheses.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Thu 12 Mar 2015 07:57:54 PM EDT
 */

public class Solution {
	public List<String> generateParenthesis(int n) {
		if (n == 0) {
			return new ArrayList<String>();
		} else if (n == 1) {
			List<String> ret = new ArrayList<String>();
			ret.add("()");
			return ret;
		}

		List<String> retRec = generateParenthesis(n-1);
		HashMap map = new HashMap();

		for (int i = 0; i < retRec.size(); i++) {
			String s = retRec.get(i);

			for (int j = 0; j < s.length(); j++) {
				String t = "";
				t = t.concat(s.substring(0, j));
				t = t.concat("()");
				t = t.concat(s.substring(j));

				if (!map.containsKey(t)) {
					map.put(t, j);
				}
			}
		}

		return new ArrayList<String>(map.keySet());
	}
}
