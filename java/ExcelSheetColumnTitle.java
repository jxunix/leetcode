/*
 * Filename: ExcelSheetColumnTitle.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 18 Jun 2015 11:20:39 AM CST
 */

public class Solution {
	public String convertToTitle(int n) {
		String res = "";

		if (n <= 0) {
			return res;
		}

		while (n > 0) {
			n--;
			char c = (char) (n % 26 + 'A');
			res = c + res;
			n /= 26;
		}

		return res;
	}
}
