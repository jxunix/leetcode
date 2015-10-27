/*
 * Filename: ClimbingStairs.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 02:24:24 PM EDT
 */

public class Solution {
	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}

		int a1 = 1;
		int a0 = 2;
		int i = 3;

		while (i <= n) {
			int temp = a0;
			a0 += a1;
			a1 = temp;
			i++;
		}

		return a0;
	}
}
