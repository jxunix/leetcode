/*
 * Filename: largest_rectangle_in_histogram.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 02 Aug 2015 09:13:30 PM EDT
 */

#include <climits>
#include <iostream>
#include <stack>

using namespace std;

class Solution {
	public:
		int largestRectangleArea(vector<int>& height)
		{
			height.push_back(INT_MIN);
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
