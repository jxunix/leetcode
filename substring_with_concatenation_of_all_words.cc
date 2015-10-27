/*
 * Filename: substring_with_concatenation_of_all_words.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 19 Aug 2015 09:40:47 PM EDT
 */

#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<int> findSubstring(string s, vector<string>& words) {
			vector<int> res;
			int m = words.size();
			int n = words[0].length();

			if (m == 0)
			{
				return res;
			}

			map<string, int> mapping;  
			for (int i = 0; i < m; i++)
			{
				mapping[words[i]]++;
			}      

			int i = 0;
			while (i < s.size())
			{
				map<string, int> mapping2;

				int j = 0;
				while (j < m)
				{
					string subs = s.substr(i+j*n, n);
					if (mapping.find(subs) == mapping.end())
					{
						break;
					}

					mapping2[subs]++;
					if (mapping2[subs] > mapping[subs])
					{
						break;
					}

					j++;  
				}

				if (j == m)
				{
					res.push_back(i);
				}

				i++;
			}

			return res;
		}
};
