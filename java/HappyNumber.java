/*
 * Filename: HappyNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 05 Jun 2015 06:43:54 AM CST
 */

public class Solution {
	public boolean isHappy(int n) {
		if (n == 1) {
			return true;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (true) {
			map.put(n, n);
			n = ssd(n);
			if (map.containsKey(n)) {
				return false;
			} else if (n == 1) {
				return true;
			}
		}

		return false;
	}

	private int ssd(int n) {
		int res = 0;
		int digit;
		while (n > 0) {
			digit = n % 10;
			res += digit * digit;
			n /= 10;
		}

		return res;
	}
}
