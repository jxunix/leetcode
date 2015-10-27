/*
 * Filename: PlusOne.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 01:52:02 PM EDT
 */

public class Solution {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[]{ 1 };
		}

		if (isAll9(digits)) {
			int[] res = new int[digits.length + 1];
			for (int i = 0; i < res.length; i++) {
				if (i == 0) {
					res[i] = 1;
				} else {
					res[i] = 0;
				}
			}
			return res;
		}

		int ditit;
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digit = carry + digits[i];
			carry = digit / 10;
			digits[i] = digit % 10;
		}

		return digits;
	}

	private boolean isAll9(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				return false;
			}
		}

		return true;
	}
}
