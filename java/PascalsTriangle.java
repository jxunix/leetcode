/*
 * Filename: PascalsTriangle.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 01:13:39 PM CST
 */

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		if (numRows <= 0) {
			return new ArrayList<List<Integer>>();
		}
		
		if (numRows == 1) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			res.add(row);
			return res;
		}

		List<List<Integer>> recRes = generate(numRows - 1);
		List<Integer> lastRow = recRes.get(recRes.size() - 1);
		List<Integer> row = new ArrayList<Integer>();

		for (int i = 0; i < lastRow.size(); i++) {
			if (i == 0) {
				row.add(1);
			} else {
				row.add(lastRow.get(i) + lastRow.get(i-1));
			}
		}

		row.add(1);
		recRes.add(row);
		return recRes;
	}
}
