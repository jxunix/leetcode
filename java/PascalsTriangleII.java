/*
 * Filename: PascalsTriangleII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 02:08:06 PM CST
 */

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> res = new ArrayList<Integer>();

		if (rowIndex == 0) {
			res.add(1);
			return res;
		}

		List<Integer> recRes = getRow(rowIndex - 1);
		for (int i = 0; i < recRes.size(); i++) {
			if (i == 0) {
				res.add(1);
			} else {
				res.add(recRes.get(i) + recRes.get(i-1));
			}
		}

		res.add(1);
		return res;
	}
}
