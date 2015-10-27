/*
 * Filename: merge_intervals.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 27 Jul 2015 12:36:07 PM EDT
 */

#include <algorithm>
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
		vector<Interval> merge(vector<Interval>& intervals) {
			if (intervals.size() < 2) {
				return intervals;
			}

			sort(intervals.begin(), intervals.end(), comp);
			vector<Interval> res;
			res.push_back(intervals[0]);

			for (vector<Interval>::size_type i = 1; i < intervals.size(); i++) {
				if (intervals[i].start <= res.back().end) {
					res.back().end = max(res.back().end, intervals[i].end);
				} else {
					res.push_back(intervals[i]);
				}
			}
		}

	private:
		bool comp(Interval a, Interval b) {
			return a.start - b.start;
		}
};
