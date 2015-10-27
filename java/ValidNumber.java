/*
 * Filename: ValidNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 09:36:15 PM EDT
 */

public class Solution {
	public boolean isNumber(String s) {
		if (s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?")) {
			return true;
		}

		return false;
	}
}
