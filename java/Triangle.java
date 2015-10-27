/*
 * Filename: Triangle.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 09:23:08 AM EDT
 */

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int m = triangle.size();
		int[] min = new int[m];
		for (int i = 0; i < m; i++) {
			min[i] = triangle.get(m-1).get(i);
		}

		for (int i = m-2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				min[j] = Math.min(min[j], min[j+1]) + triangle.get(i).get(j);
			}
		}

		return min[0];
	}
}
