/*
 * Filename: Sqrt.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 02:09:01 PM EDT
 */

public class Solution {
	public int mySqrt(int x) {
		double res = Math.pow(Math.E, Math.log(x) / 2.0);
		int resInt = (int) res;

		if (Math.abs(resInt + 1 - res) < 0.000001) {
			return resInt + 1;
		} else {
			return resInt;
		}
	}
}
