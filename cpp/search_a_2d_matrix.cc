/*
 * Filename: search_a_2d_matrix.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 01 Aug 2015 07:48:45 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		bool searchMatrix(vector<vector<int>>& matrix, int target) {
			if (!matrix.size() || !matrix[0].size()) {
				return false;
			}

			int m = matrix.size();
			int n = matrix[0].size();
			int stt = 0;
			int end = m * n - 1;
			int mid = -1;

			while (stt <= end) {
				mid = (stt + end) / 2;
				int i = mid / n;
				int j = mid % n;

				if (matrix[i][j] == target) {
					return true;
				} else if (matrix[i][j] > target) {
					end = mid - 1;
				} else {
					stt = mid + 1;
				}
			}

			return false;
		}
};
