/*
 * Filename: minimum_path_sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 31 Jul 2015 08:31:22 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int minPathSum(vector<vector<int> >& grid) {
			if (!grid.size() || !grid[0].size()) {
				return 0;
			}

			int m = grid.size();
			int n = grid[0].size();
			int dp[n];
			dp[0] = grid[0][0];

			for (size_t j = 1; j < n; j++) {
				dp[j] = dp[j-1] + grid[0][j];
			}

			for (size_t i = 1; i < m; i++) {
				dp[0] += grid[i][0];

				for (size_t j = 1; j < n; j++) {
					dp[j] = min(dp[j], dp[j-1]) + grid[i][j];
				}
			}

			return dp[n-1];
		}
};
