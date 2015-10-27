/*
 * Filename: substring_with_concatenation_of_all_words.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 19 Aug 2015 09:40:47 PM EDT
 */

#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<int> findSubstring(string s, vector<string>& words) {
			vector<int> res;

			int m = s.length();
			int n = words.size();
			if (m == 0 || n == 0)
			{
				return res;
			}

			int l = words[0].length();
			if (l == 0)
			{
				return res;
			}

			map<string, int> mapping;
			for (auto w: words)
			{
				mapping[w]++;
			}

			int i = 0;
			while (i + n*l <= m)
			{
				map<string, int> mapping2;

				int j = i;
				while (j < m)
				{
					string sub = s.substr(j, l);
					if (mapping.find(sub) == mapping.end())
					{
						break;
					}
					else
					{
						mapping2[sub]++;
						if (mapping2[sub] > mapping[sub])
						{
							break;
						}

						j += l;
					}
				}

				if (j-i == n*l)
				{
					res.push_back(i);
				}

				i++;
			}

			return res;
		}
};
