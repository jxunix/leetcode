/*
 * Filename: NextPermutation.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 20 Mar 2015 05:59:58 PM EDT
 */

public class Solution {
	public static void nextPermutation(int[] num) {
		if (num.length < 2) {
			return;
		}

		int i = num.length - 1;
		while (i > 0 && num[i-1] >= num[i]) {
			i--;
		}

		int j;
		int temp;

		if (i > 0) {
			j = num.length - 1;
			while (j >= i && num[j] <= num[i-1]) {
				j--;
			}

			temp = num[j];
			num[j] = num[i-1];
			num[i-1] = temp;
		}

		j = num.length - 1;

		while (j > i) {
			temp = num[j];
			num[j] = num[i];
			num[i] = temp;
			j--;
			i++;
		}

		return;
	}
}
