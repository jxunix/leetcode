/*
 * Filename: WordLadder.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 03:31:57 PM EDT
 */

public class Solution {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		dict.add(end);
		dict.remove(start);

		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, Set<String>> parents = new HashMap<String, Set<String>>();

		Queue<String> queue = new LinkedList<String>();
		Queue<String> queue2 = null;
		queue.add(start);

		while (!queue.isEmpty()) {
			queue2 = new LinkedList<String>();

			for (String s: queue) {
				if (s.equals(end)) {
					Stack<String> path = new Stack<String>();
					path.add(end);
					getPath(start, end, path, parents, res);
					return res;
				}

				for (String t: getNbr(s, dict)) {
					queue2.add(t);

					if (parents.containsKey(t)) {
						parents.get(t).add(s);
					} else {
						Set<String> prts = new HashSet<String>();
						prts.add(s);
						parents.put(t, prts);
					}
				}
			}

			dict.removeAll(queue2);
			queue = queue2;
		}

		return res;
	}

	private void getPath(String s, String t, Stack<String> path, HashMap<String, Set<String>> parents, List<List<String>> res) {
		if (s.equals(t)) {
			List<String> rev = new ArrayList<String>();
			rev.addAll(path);
			Collections.reverse(rev);
			res.add(rev);
			return;
		}

		for (String prt: parents.get(t)) {
			path.push(prt);
			getPath(s, prt, path, parents, res);
			path.pop();
		}
	}

	private Set<String> getNbr(String s, Set<String> dict) {
		Set<String> nbrs = new HashSet<String>();
		char[] arr = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			char old = arr[i];

			for (char c = 'a'; c <= 'z'; c++) {
				if (arr[i] == c) {
					continue;
				}

				arr[i] = c;
				String t = new String(arr);

				if (dict.contains(t)) {
					nbrs.add(t);
				}
			}

			arr[i] = old;
		}

		return nbrs;
	}
}
