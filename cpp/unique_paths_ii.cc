/*
 * Filename: unique_paths_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 31 Jul 2015 07:39:13 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int uniquePathsWithObstacles(vector<vector<int> >& obstacleGrid) {
			if (!obstacleGrid.size() || !obstacleGrid[0].size()) {
				return 0;
			}

			int m = obstacleGrid.size();
			int n = obstacleGrid[0].size();

			int dp[n];
			dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

			for (size_t j = 1; j < n; j++) {
				dp[j] = obstacleGrid[0][j] == 1 ? 0 : dp[j-1];
			}

			for (size_t i = 1; i < m; i++) {
				if (obstacleGrid[i][0] == 1) {
					dp[0] = 0;
				}

				for (size_t j = 1; j < n; j++) {
					if (obstacleGrid[i][j] == 1) {
						dp[j] = 0;
					} else if (obstacleGrid[i-1][j] == 1) {
						dp[j] = dp[j-1];
					} else if (obstacleGrid[i][j-1] != 1) {
						dp[j] += dp[j-1];
					}
				}
			}

			return dp[n-1];
		}
};
