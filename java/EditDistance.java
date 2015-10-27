/*
 * Filename: EditDistance.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 04:12:56 PM EDT
 */

public class Solution {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) {
			return 0;
		} else if (word1 == null) {
			return word2.length();
		} else if (word2 == null) {
			return word1.length();
		}

		if (word1.length() == 0 && word2.length() == 0) {
			return 0;
		} else if (word1.length() == 0) {
			return word2.length();
		} else if (word2.length() == 0) {
			return word1.length();
		}

		int m = word2.length();
		int n = word1.length();
		int[] costs = new int[n];
		int[] costsPrev = new int[n];
		int[] tmp;

		char w1 = word1.charAt(0);
		char w2 = word2.charAt(0);
		int cost1 = 0;
		int cost2 = 0;
		int cost3 = 0;

		for (int i = 0; i < costs.length; i++) {
			if (word1.charAt(i) == w2) {
				if (i == 0) {
					costs[i] = 0;
				} else {
					cost1 = i;
					cost2 = costs[i-1] + 1;
					costs[i] = Math.min(cost1, cost2);
				}
			} else {
				if (i == 0) {
					costs[i] = 1;
				} else {
					cost1 = i+1;
					cost2 = costs[i-1] + 1;
					costs[i] = Math.min(cost1, cost2);
				}
			}

			costsPrev[i] = costs[i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				w2 = word2.charAt(i);

				if (j == 0) {
					if (w2 == w1) {
						cost1 = i;
					} else {
						cost1 = i+1;
					}
					
					cost2 = costsPrev[j] + 1;
					costs[j] = Math.min(cost1, cost2);
				} else {
					if (w2 == word1.charAt(j)) {
						cost1 = costsPrev[j-1];
					} else {
						cost1 = costsPrev[j-1] + 1;
					}

					cost2 = costsPrev[j] + 1;
					cost3 = costs[j-1] + 1;
					costs[j] = Math.min(Math.min(cost1, cost2), cost3);
				}
			}

			tmp = costs;
			costs = costsPrev;
			costsPrev = tmp;
		}

		return costsPrev[n-1];
	}
}
