/*
 * Filename: unique_paths.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 31 Jul 2015 04:33:54 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int uniquePaths(int m, int n) {
			if (!m || !n) {
				return 0;
			}

			int dp[n];
			for (size_t j = 0; j < n; j++) {
				dp[j] = 1;
			}

			for (size_t i = 1; i < m; i++) {
				for (size_t j = 1; j < n; j++) {
					dp[j] += dp[j-1];
				}
			}

			return dp[n-1];
		}
};
