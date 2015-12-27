/*
 * Filename: max_points_on_a_line.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 09:19:09 PM EST
 * Description: 
 */

#include <climits>
#include <iostream>
#include "point.hpp"

using namespace std;

/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */

class Solution {
	public:
		int maxPoints(vector<Point>& points) {
			int n = points.size();
			if (n <= 2)
			{
				return n;
			}

			int res = 1;
			double slope;
			map<double, int> map;

			for (auto i = 0; i < n; i++)
			{
				map.clear();
				int dup = 1;

				for (auto j = 0; j < n; j++)
				{
					if (i == j)
					{
						continue;
					}

					if (points[i].x == points[j].x && points[i].y == points[j].y)
					{
						dup++;
						continue;
					}
					else if (points[i].x == points[j].x)
					{
						slope = INT_MAX;
					}
					else if (points[i].y == points[j].y)
					{
						slope = 0;
					}
					else
					{
						slope = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
					}

					if (map.find(slope) != map.end())
					{
						map[slope]++;
					}
					else
					{
						map[slope] = 1;
					}
				}

				if (map.empty())
				{
					res = dup;
				}
				else
				{
					for (const auto& e : map)
					{
						res = max(res, e.second + dup);
					}
				}
			}

			return res;
		}
};
