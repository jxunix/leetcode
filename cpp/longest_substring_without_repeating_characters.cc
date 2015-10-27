/*
 * Filename: longest_substring_without_repeating_characters.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 19 Aug 2015 07:37:16 PM EDT
 */

#include <climits>
#include <iostream>
#include <map>
#include <string>

using namespace std;

class Solution {
	public:
		int lengthOfLongestSubstring(string s) {
			map<char, int> mapping;
			int res = 0;
			int j = 0;

			for (int i = 0; i < s.length(); i++)
			{
				if (mapping.find(s[i]) != mapping.end())
				{
					res = max(res, i-j);
					j = max(mapping[s[i]] + 1, j);
				}

				mapping[s[i]] = i;
			}

			return max(res, (int) s.length() - j);
		}
};
