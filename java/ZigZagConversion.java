/*
 * Filename: ZigZagConversion.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 04 Mar 2015 05:33:04 PM EST
 */

public class Solution {
	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}

		String res = "";
		int mod = 2 * (nRows - 1);

		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < s.length; j++) {
				if (i == 0) {
					if (j % mod == i)	{
						res += s.charAt(j);
					}
				} else if (i == nRows - 1) {
					if (j % mod == i) {
						res += s.charAt(j);
					}
				} else {
					if (j % mod == i || j % mod == mod - i) {
						res += s.charAt(j);
					}
				}
			}
		}

		return res;
	}
}
