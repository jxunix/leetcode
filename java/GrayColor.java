/*
 * Filename: GrayColor.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 27 May 2015 01:57:25 PM EDT
 */

public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n < 0) {
			return res;
		}

		if (n == 0) {
			res.add(0);
			return res;
		}

		if (n == 1) {
			res.add(0);
			res.add(1);
			return res;
		}

		List<Integer> recRes = grayCode(n-1);
		for (int i = recRes.size() - 1; i >= 0; i--) {
			res.add(recRes.get(i) + (int) Math.pow(2, n-1));
		}
		recRes.addAll(res);
		return recRes;
	}
}
