/*
 * Filename: longest_consecutive_sequence.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 07 Aug 2015 07:10:55 PM EDT
 */

#include <iostream>
#include <unordered_set>

using namespace std;

class Solution {
	public:
		int longestConsecutive(vector<int>& nums)
		{
			if (nums.empty())
			{
				return 0;
			}

			unordered_set<int> set;
			int res = 0;

			for (int n : nums)
			{
				set.insert(n);
			}

			for (int n : set)
			{
				int val = n;
				int cnt = 1;

				while (set.find(++val) != set.end())
				{
					set.erase(val);
					cnt++;
				}

				val = n;

				while (set.find(--val) != set.end())
				{
					set.erase(val);
					cnt++;
				}

				res = max(res, cnt);

				for (int n : set)
				{
					cout << n << " ";
				}
				cout << endl;
			}

			return res;
		}
};
