/*
 * Filename: SlidingWindowMaximum.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 19 Jul 2015 05:02:39 PM EDT
 */

public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int n = nums.length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] res = new int[n-k+1];

		for (int i = 0; i < w; i++) {
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}

			queue.add(i);
		}

		res[0] = nums[queue.peekFirst()];

		for (int i = w; i < n; i++) {
			while (!queue.isEmpty() && queue.peekFirst() <= i-w) {
				queue.removeFirst();
			}

			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}

			queue.add(i);
			res[i-w+1] = nums[queue.peekFirst()];
		}

		return res;
	}
}
