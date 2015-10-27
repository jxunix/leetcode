/*
 * Filename: set_matrix_zeroes.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 01 Aug 2015 07:12:37 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		void setZeroes(vector<vector<int>>& matrix) {
			if (!matrix.size() || !matrix[0].size()) {
				return;
			}

			int m = matrix.size();
			int n = matrix[0].size();
			bool row = false;
			bool col = false;

			if (!matrix[0][0]) {
				row = true;
				col = true;
			} else {
				for (vector<int>::size_type i = 1; i < m; i++) {
					if (!matrix[i][0]) {
						col = true;
						break;
					}
				}

				for (vector<int>::size_type j = 1; j < n; j++) {
					if (!matrix[0][j]) {
						row = true;
						break;
					}
				}
			}

			for (vector<int>::size_type i = 1; i < m; i++) {
				for (vector<int>::size_type j = 1; j < n; j++) {
					if (matrix[i][j]) {
						continue;
					}

					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

			for (vector<int>::size_type i = 1; i < m; i++) {
				if (!matrix[i][0]) {
					for (vector<int>::size_type j = 1; j < n; j++) {
						matrix[i][j] = 0;
					}
				}
			}

			for (vector<int>::size_type j = 1; j < n; j++) {
				if (!matrix[0][j]) {
					for (vector<int>::size_type i = 1; i < m; i++) {
						matrix[i][j] = 0;
					}
				}
			}

			if (col) {
				for (vector<int>::size_type i = 0; i < m; i++) {
					matrix[i][0] = 0;
				}
			}

			if (row) {
				for (vector<int>::size_type j = 0; j < n; j++) {
					matrix[0][j] = 0;
				}
			}
		}
};
