/*
 * Filename: insert_interval.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 27 Jul 2015 12:52:14 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
	public:
		vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
			vector<Interval> res;
			int i = 0;

			for (; i < intervals.size() && intervals[i].end < newInterval.start; i++) {
				res.push_back(intervals[i]);
			}

			if (i == intervals.size()) {
				res.push_back(newInterval);
				return res;
			}

			newInterval.start = min(newInterval.start, intervals[i].start);

			for (; i < intervals.size() && intervals[i].start <= newInterval.end; i++) {
				newInterval.end = max(newInterval.end, intervals[i].end);
			}

			res.push_back(newInterval);

			for (; i < intervals.size(); i++) {
				res.push_back(intervals[i]);
			}

			return res;
		}
};
