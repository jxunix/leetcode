/*
 * Filename: Candy.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 06:39:30 PM EDT
 */

public class Solution {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int i = 0;
		int cnt = 0;
		int res = 0;

		while (i < ratings.length) {
			if (i == 0 || ratings[i] > ratings[i-1]) {
				res += ++cnt;
				i++;
			} else if (ratings[i] == ratings[i-1]) {
				cnt = 1;
				res += cnt;
				i++;
			} else {
				int j = i;

				while (j < ratings.length && ratings[j] < ratings[j-1]) {
					j++;
				}

				int sum = (j-i+2) * (j-i+1) / 2 - Math.min(cnt, j-i+1);
				res += sum;
				i = j;
				cnt = 1;
			}
		}

		return res;
	}
}
