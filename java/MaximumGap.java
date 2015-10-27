/*
 * Filename: MaximumGap.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 01:12:07 PM EDT
 */

public class Solution {
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int max = nums[0];
		int min = nums[0];
		for (int n : nums) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}

		int gap = (int) Math.ceil ((double) (max - min) / (nums.length - 1));  
		int bucketNum = (max - min) / gap + 1;
		Bucket[] buckets = new Bucket[bucketNum];

		for (int i = 0; i < bucketNum; i++) {
			buckets[i] = new Bucket();
		}

		for (int n : nums) {
			int i = (n - min) / gap;

			if (buckets[i].low == -1) {
				buckets[i].low = n;
				buckets[i].high = n;
			} else {
				buckets[i].low = Math.min(buckets[i].low, n);
				buckets[i].high = Math.max(buckets[i].high, n);
			}
		}

		int res = 0;
		int prev = buckets[0].high;

		for (int i = 1; i < bucketNum; i++) {
			if (buckets[i].low != -1) {
				res = Math.max(res, buckets[i].low - prev);
				prev = buckets[i].high;
			}
		}

		return res;
	}

	class Bucket {
		int low;
		int high;

		public Bucket() {
			low = -1;
			high = -1; 
		}
	}
}
