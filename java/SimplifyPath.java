/*
 * Filename: SimplifyPath.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 02:35:48 PM EDT
 */

public class Solution {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return null;
		}

		int i = 0;
		int mark = 0;
		String res = "";
		String dir = "";
		List<Integer> lens = new ArrayList<Integer>();

		while (i < path.length()) {
			while (i < path.length() && path.charAt(i) == '/') {
				i++;
			}
			mark = i;

			if (i == path.length()) {
				break;
			}

			while (i < path.length() && path.charAt(i) != '/') {
				i++;
			}

			dir = path.substring(mark, i);
			if (dir.equals("..")) {
				if (lens.size() > 0) {
					int len = lens.remove(0);
					res = res.substring(0, res.length() - len - 1);
				}
			} else if (!dir.equals(".")) {
				lens.add(0, dir.length());
				res += "/" + dir;
			}
		}

		if (res.equals("")) {
			return "/";
		}

		return res;
	}
}
