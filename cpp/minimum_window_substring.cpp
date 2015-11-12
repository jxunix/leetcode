/*
 * Filename: minimum_window_substring.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 05 Nov 2015 11:56:14 PM EST
 * Description: 
 */

#include <iostream>
#include <queue>

using namespace std;

class Solution {
	public:
		string minWindow(string s, string t) {
			int s_length = s.length();
			int t_length = t.length();

			int src_cnt[256] = { 0 };
			int dst_cnt[256] = { 0 };

			int cnt = 0;
			int left = -1;
			int right = s_length;
			queue<int> q;

			for (const char& c : t)
			{
				src_cnt[c]++;
			}

			for (int i = 0; i < s_length; i++)
			{
				char c = s[i];
				if (src_cnt[c])
				{
					q.push(i);
					dst_cnt[c]++;

					if (dst_cnt[c] <= src_cnt[c])
					{
						cnt++;
					}

					if (cnt == t_length)
					{
						int j;
						cnt--;

						do
						{
							j = q.front();
							q.pop();
							dst_cnt[s[j]]--;
						}
						while (dst_cnt[s[j]] >= src_cnt[s[j]]);

						if (i - j < right - left)
						{
							right = i;
							left = j;
						}
					}
				}
			}

			return left == -1 ? "" : s.substr(left, right - left + 1);
		}
};
