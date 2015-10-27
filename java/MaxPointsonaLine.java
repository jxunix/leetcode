/*
 * Filename: MaxPointsonaLine.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 19 Jul 2015 03:35:22 PM EDT
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		}

		int n = points.length;
		if (n <= 2) {
			return n;
		}

		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < n; i++) {
			Point p = points[i];
			map.clear();
			int dup = 1;

			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				Point q = points[j];
				if (p.x == q.x && p.y == q.y) {
					dup++;
					continue;
				}

				double slope;
				if (p.x == q.x) {
					slope = Integer.MAX_VALUE;
				} else if (p.x == q.y) {
					slope = 0;
				} else {
					slope = 1.0 * (double) (p.y - q.y) / (double) (p.x - q.x);
				}

				map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
			}

			if (map.isEmpty()) {
				max = dup;
			} else {
				for (Double k : map.keySet()) {
					max = Math.max(max, dup + map.get(k));
				}
			}
		}

		return max;
	}
}
