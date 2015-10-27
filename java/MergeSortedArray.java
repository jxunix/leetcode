/*
 * Filename: MergeSortedArray.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 27 May 2015 12:52:53 PM EDT
 */

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		System.out.println(m + ", " + n);
		if (n == 0) {
			return;
		}

		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j]) {
				nums1[k--] = nums2[j--];
			} else {
				nums1[k--] = nums1[i--];
			}
		}

		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
