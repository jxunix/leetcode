/*
 * Filename: combination_sum_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 25 Jul 2015 08:42:53 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<int> > combinationSum2(vector<int>& candidates, int target) {
			vector<vector<int> > res;
			vector<int> v;
			sort(candidates.begin(), candidates.end());
			combination_sum2_aux(candidates, target, -1, res, v);
			return res;
		}

	private:
		void combination_sum2_aux(vector<int>& candidates, int target, int i, vector<vector<int> >& res, vector<int>& v) {
			if (target == 0) {
				res.push_back(v);
			} else if (target > 0) {
				for (vector<int>::size_type j = i+1; j < candidates.size(); j++) {
					if (j-i-1 && candidates[j] == candidates[j-1]) {
						continue;
					}

					v.push_back(candidates[j]);
					combination_sum2_aux(candidates, target - candidates[j], j, res, v);
					v.pop_back();
				}
			}
		}
};
