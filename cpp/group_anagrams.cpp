/*
 * Filename: group_anagrams.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 03 Nov 2015 11:58:21 PM EST
 * Description: 
 */

#include <algorithm>
#include <iostream>
#include <map>
#include <string>

using namespace std;

class Solution {
	public:
		vector<vector<string> > groupAnagrams(vector<string>& strs)
		{
			vector<vector<string> > res;
			map<string, vector<int> > mapping;

			sort(strs.begin(), strs.end());

			for (auto i = 0; i < strs.size(); i++)
			{
				string s = strs[i];
				sort(s.begin(), s.end());
				mapping[s].push_back(i);
			}

			for (const auto& e : mapping)
			{
				vector<string> row;
				for (const auto& i : e.second)
				{
					row.push_back(strs[i]);
				}
				res.push_back(row);
			}

			return res;
		}
};
