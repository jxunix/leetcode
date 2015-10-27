/*
 * Filename: Anagrams.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 13 May 2015 01:26:57 PM EDT
 */

public class Solution {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return res;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for(int i = 0; i < strs.length; i++) {
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String str = new String(charArr);

			if (map.containsKey(str)) {
				map.get(str).add(strs[i]);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(str, list);
			}
		}

		Iterator iter = map.values().iterator();
		while (iter.hasNext()) {
			List<String> item = (List<String>) iter.next();
			if (item.size() > 1)
				res.addAll(item);
		}

		return res;
	}
}
