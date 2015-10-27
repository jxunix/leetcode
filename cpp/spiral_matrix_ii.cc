/*
 * Filename: spiral_matrix.ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 27 Jul 2015 12:17:43 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<vector<int> > generateMatrix(int n) {
			vector<vector<int> > res;
			int val = 1;

			for (vector<int>::size_type i = 0; i < n; i++) {
				vector<int> v;

				for (vector<int>::size_type j = 0; j < n; j++) {
					v.push_back(0);
				}

				res.push_back(v);
			}

			for (vector<int>::size_type i = 0; i < n; i++) {
				int step = n - 2 * i - 1;

				for (vector<int>::size_type j = i; j < n-i-1; j++) {
					res[i][j] = val;
					res[j][n-i-1] = val + step;
					res[n-i-1][n-j-1] = val + 2 * step;
					res[n-j-1][i] = val + 3 * step;
					val++;
				}

				val += 3 * step;
			}

			if (n & 0x1) {
				res[n/2][n/2] = n * n;
			}

			return res;
		}
};
