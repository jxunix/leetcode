/*
 * Filename: repeated_dna_sequences.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 17 Nov 2015 12:12:36 AM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution {
	public:
		vector<string> findRepeatedDnaSequences(string s) {
			vector<string> res;

			if (s.length() <= 10)
			{
				return res;
			}

			map<int, int> dupmap;
			map<char, int> map;
			map['A'] = 0;
			map['C'] = 1;
			map['G'] = 2;
			map['T'] = 3;

			int hash = 0;
			for (int i = 0; i < s.length(); i++)
			{
				if (i < 9)
				{
					hash = (hash << 2) + map[s[i]];
				}
				else
				{
					hash = (hash << 2) + map[s[i]];
					hash = hash & (1 << 20) - 1;

					if (dupmap.find(hash) != dupmap.end())
					{
						if (dupmap[hash] == 1)
						{
							res.push_back(s.substr(i-9, 10));
							dupmap[hash] = 2;
						}
					}
					else
					{
						dupmap[hash] = 1;
					}
				}
			}

			return res;
		}
};
