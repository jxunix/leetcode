/*
 * Filename: combination_sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 25 Jul 2015 05:20:58 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<int> > combinationSum(vector<int>& candidates, int target) {
			vector<vector<int> > res;
			vector<int> v;
			sort(candidates.begin(), candidates.end());
			combination_sum_aux(candidates, 0, target, v, res);
			return res;
		}

	private:
		void combination_sum_aux
				(vector<int>& candidates, int i, int target, vector<int>& v, vector<vector<int> >& res) {
			if (target == 0) {
				res.push_back(v);
			} else if (target > 0) {
				for (vector<int>::size_type j = i; j < candidates.size(); j++) {
					v.push_back(candidates[j]);
					combination_sum_aux(candidates, j, target - candidates[j], v, res);
					v.pop_back();
				}
			}
		}
};
