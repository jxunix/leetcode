/*
 * Filename: spiral_matrix.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 27 Jul 2015 11:26:56 AM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<int> spiralOrder(vector<vector<int> >& matrix) {
			if (matrix.size() == 0 || matrix[0].size() == 0) {
				return res;
			}

			vector<int> res;

			int m = matrix.size();
			int n = matrix[0].size();
			int layer = min(m, n) / 2;

			for (vector<int>::size_type i = 0; i < layer; i++) {
				for (vector<int>::size_type j = i; j <= n-i-2; j++) {
					res.push_back(matrix[i][j]);
				}

				for (vector<int>::size_type j = i; j <= m-i-2; j++) {
					res.push_back(matrix[j][n-i-1]);
				}

				for (vector<int>::size_type j = i; j <= n-i-2; j++) {
					res.push_back(matrix[m-i-1][n-j-1]);
				}

				for (vector<int>::size_type j = i; j <= m-i-2; j++) {
					res.push_back(matrix[m-j-1][i]);
				}
			}

			if (m > n && (n & 0x1)) {
				for (vector<int>::size_type i = layer; i < m - layer; i++) {
					res.push_back(matrix[i][n/2]);
				}
			} else if (n >= m && (m & 0x1)) {
				for (vector<int>::size_type i = layer; i < n - layer; i++) {
					res.push_back(matrix[m/2][i]);
				}
			}

			return res;
		}
};
