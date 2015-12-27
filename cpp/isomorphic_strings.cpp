/*
 * Filename: isomorphic_strings.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sat 26 Dec 2015 09:05:18 PM EST
 * Description: 
 */

#include <iostream>
#include <map>
#include <string>

using namespace std;

class Solution
{
	public:
		bool isIsomorphic(string s, string t)
		{
			map<char, char> forwardMap;
			map<char, char> backwardMap;

			for (size_t i = 0; i < s.length(); i++)
			{
				char cs = s[i];
				char ct = t[i];

				if (forwardMap.find(cs) != forwardMap.end())
				{
					if (ct != forwardMap[cs])
					{
						return false;
					}
				}
				else
				{
					if (backwardMap.find(ct) != backwardMap.end())
					{
						if (cs != backwardMap[ct])
						{
							return false;
						}
					}
					else
					{
						backwardMap[ct] = cs;
					}

					forwardMap[cs] = ct;
				}
			}

			return true;
		}
};
