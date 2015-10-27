/*
 * Filename: PalindromeNumber.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 04 Mar 2015 08:23:59 PM EST
 */

public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		if (x < 10) {
			return true;
		}

		if (x % 10 == 0) {
			return false;
		}

		int rev = 0;
		int digit;

		while (x > rev) {
			digit = x % 10;
			x = x / 10;
			rev = rev * 10 + digit;
		}

		if (x == rev || x == rev / 10) {
			return true;
		} else {
			return false;
		}
	}
}
