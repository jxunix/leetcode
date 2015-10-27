/*
 * Filename: NumberofDigitOne.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 07 Jul 2015 03:29:49 PM EDT
 */

public class Solution {
	public int countDigitOne(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] bits = new int[32];
		int n2 = n;
		int res = 0;
		int size = 0;

		while (n2 > 0) {
			bits[size++] = n2 % 10;
			n2 /= 10;
		}

		for (int i = 0; i < size; i++) {
			if (bits[i] == 0) {
				int a = n / (int) Math.pow(10, i+1) * (int) Math.pow(10, i);
				int b = n % (int) Math.pow(10, i);
				res += a + b + 1;
			} else if (bits[i] == 1) {
				res += (n / (int) Math.pow(10, i+1) + 1) * (int) Math.pow(10, i);
			} else {
				res += n / (int) Math.pow(10, i+1) * (int) Math.pow(10, i);
			}
		}

		return res;
	}
}
