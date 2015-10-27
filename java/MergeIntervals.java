/*
 * Filename: MergeIntervals.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 17 May 2015 05:36:28 PM EDT
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
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i2.end - i1.end;
			}
		});

		Interval curr;

		while (!intervals.isEmpty()) {
			curr = intervals.remove(0);

			while (!intervals.isEmpty() && intervals.get(0).end >= curr.start) {
				Interval i = intervals.remove(0);
				curr.start = Math.min(curr.start, i.start);
			}

			res.add(curr);
		}

		return res;
	}
}
