/*
 * Filename: triangle.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 05 Aug 2015 06:27:18 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int minimumTotal(vector<vector<int> >& triangle)
		{
			if (triangle.empty())
			{
				return 0;
			}

			int n = triangle.size();
			vector<int> mins = triangle.back();

			for (int i = n-2; i >= 0; i--)
			{
				for (int j = 0; j <= i; j++)
				{
					mins[j] = min(mins[j], mins[j+1]) + triangle[i][j];
				}
			}

			return mins[0];
		}
};
