/*
 * Filename: maximal_rectangle.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 03 Aug 2015 09:05:04 PM EDT
 */

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
	public:
		int maximalRectangle(vector<vector<char> >& matrix)
		{
			if (!matrix.size() || !matrix[0].size())
			{
				return 0;
			}

			int m = matrix.size();
			int n = matrix[0].size();
			int res = 0;
			vector<vector<int> > histograms (m, vector<int> (n+1, 0));

			for (size_t i = 0; i < m; i++)
			{
				for (size_t j = 0; j < n; j++)
				{
					if (matrix[i][j] - '0')
					{
						histograms[i][j] = i == 0 ? 1 : histograms[i-1][j] + 1;
					}
				}
			}

			for (size_t i = 0; i < m; i++)
			{
				res = max(res, largest_rectangle_area(histograms[i]));
			}

			return res;
		}

	private:
		int largest_rectangle_area(vector<int>& height)
		{
			stack<int> stack;
			int res = 0;
			int i = 0;

			while (i < height.size())
			{
				if (stack.empty() || height[i] >= height[stack.top()])
				{
					stack.push(i++);
				}
				else
				{
					int idx = stack.top();
					stack.pop();
					int width = stack.empty() ? i : i - stack.top() - 1;
					res = max(res, width * height[idx]);
				}
			}

			return res;
		}
};
