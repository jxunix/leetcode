/*
 * Filename: Point.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 19 Jul 2015 03:35:42 PM EDT
 */

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	public static Point[] create(int[][] nums) {
		Point[] points = new Point[nums.length];

		for (int i = 0; i < nums.length; i++) {
			points[i] = new Point(nums[i][0], nums[i][1]);
		}

		return points;
	}
}
