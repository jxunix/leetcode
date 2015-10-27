/*
 * Filename: word_ladder_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 07 Aug 2015 06:31:40 PM EDT
 */

#include <algorithm>
#include <climits>
#include <iostream>
#include <map>
#include <queue>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<string> > findLadders(
				string start,
				string end,
				unordered_set<string>& dict)
		{
			unordered_set<string> level;
			unordered_set<string> level2;

			mapping.clear();
			res.clear();
			path.clear();

			dict.insert(end);
			path.push_back(end);
			level.insert(start);

			while (!level.empty())
			{
				for (auto it = level.begin(); it != level.end(); it++)
				{
					dict.erase(*it);
				}

				for (auto it = level.begin(); it != level.end(); it++)
				{
					get_nbr(*it, level2, dict);
				}

				if (level2.find(end) != level2.end())
				{
					output(start, end);
					return res;
				}

				level.clear();
				level = level2;
				level2.clear();
			}

			return res;
		}

	private:
		map<string, vector<string> > mapping;
		vector<vector<string> > res;
		vector<string> path;

		void get_nbr(
				string s,
				unordered_set<string>& level2,
				unordered_set<string>& dict)
		{
			for (int i = 0; i < s.length(); i++)
			{
				string s2 = s;

				for (char j = 'a'; j <= 'z'; j++)
				{
					s2[i] = j;

					if (dict.find(s2) != dict.end())
					{
						level2.insert(s2);
						mapping[s2].push_back(s);
					}
				}
			}
		}

		void output(
				string start,
				string end)
		{
			if (start == end)
			{
				reverse(path.begin(), path.end());
				res.push_back(path);
				reverse(path.begin(), path.end());
				return;
			}

			vector<string> v = mapping[end];
			for (auto it = v.begin(); it != v.end(); it++)
			{
				path.push_back(*it);
				output(start, *it);
				path.pop_back();
			}
		}
};
