/*
 * Filename: largest_rectangle_in_histogram.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 12 Nov 2015 07:50:24 PM EST
 * Description: 
 */

#include <climits>
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution
{
	public:
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
