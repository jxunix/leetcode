/*
 * Filename: maximal_rectangle.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Wed 11 Nov 2015 11:30:22 PM EST
 * Description: 
 */

#include <climits>
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
	public:
		int maximalRectangle(vector<vector<char> >& matrix)
		{
			if (matrix.size() == 0 || matrix[0].size() == 0)
			{
				return 0;
			}

			int m = matrix.size();
			int n = matrix[0].size();

			vector<vector<int> > heights (m, vector<int> (n, 0));
			for (auto i = 0; i < n; i++)
			{
				heights[0][i] = matrix[0][i] == '0' ? 0 : 1;
			}

			int max_area = largestRectangleArea(heights[0]);
			for (auto i = 1; i < m; i++)
			{
				for (auto j = 0; j < n; j++)
				{
					heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i-1][j]+1;
				}

				max_area = max(max_area, largestRectangleArea(heights[i]));
			}

			return max_area;
		}

	private:
		int largestRectangleArea(vector<int>& height)
		{
			height.push_back(INT_MIN);
			int max_area = 0;
			stack<int> stack;

			for (int i = 0; i < height.size(); )
			{
				if (stack.empty() || height[i] >= height[stack.top()])
				{
					stack.push(i++);
				}
				else
				{
					int h = stack.top();
					stack.pop();
					int w = stack.empty() ? i : i - stack.top() - 1;
					max_area = max(max_area, w * height[h]);
				}
			}

			return max_area;
		}
};
