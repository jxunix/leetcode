/*
 * Filename: ExcelSheetColumnNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 17 Jun 2015 05:49:10 PM CST
 */

public class Solution {
	public int titleToNumber(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		int res = 0;
		int bit = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			res += (s.charAt(i) - 'A' + 1) * bit;
			bit *= 26;
		}

		return res;
	}
}
