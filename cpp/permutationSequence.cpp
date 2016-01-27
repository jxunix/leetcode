/*
 * Filename: permutationSequence.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 26 Jan 2016 10:35:39 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		string getPermutation(int n, int k)
		{
			vector<int> vec;
			for (int i = 1; i <= n; i++)
			{
				vec.push_back(i);
			}

			string res = "";
			k--;
			for (int i = n; i > 0; i--)
			{
				int fac = factorial(i-1);
				int idx = k / fac;
				k %= fac;
				res += to_string(vec[idx]);
				vec.erase(vec.begin() + idx);
			}

			return res;
		}

	private:
		int factorial(int n)
		{
			if (n == 0)
			{
				return 1;
			}

			return (factorial(n-1) * n);
		}
};
