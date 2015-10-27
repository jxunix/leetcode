/*
 * Filename: ContainerWithMostWater.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 01:42:11 PM EDT
 */

public class Solution {
	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int max = 0;

		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}

		return max;
	}
}
