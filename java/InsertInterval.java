/*
 * Filename: InsertInterval.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 12:32:15 PM EDT
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) {
			return intervals;
		}

		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}

		boolean doing = false;
		boolean done = false;

		for (Interval i: intervals) {
			if (i.end < newInterval.start) {
				res.add(i);
			} else {
				if (!doing) {
					if (i.start > newInterval.end) {
						res.add(newInterval);
						res.add(i);
						done = true;
					} else {
						res.add(new Interval(
									Math.min(newInterval.start, i.start),
									Math.max(newInterval.end, i.end)));
					}
					doing = true;
				} else {
					if (!done) {
						if (i.start > res.get(res.size() - 1).end) {
							done = true;
							res.add(i);
						} else {
							res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, i.end);
						}
					} else {
						res.add(i);
					}
				}
			}
		}

		if (!doing) {
			res.add(newInterval);
		}

		return res;
	}
}
