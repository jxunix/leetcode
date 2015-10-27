/*
 * Filename: median_of_two_sorted_arrays.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:51:18 AM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
			int len = nums1.size() + nums2.size();

			if (len & 0x1) {
				return find_kth(nums1, 0, nums2, 0, len / 2 + 1);
			} else {
				return (find_kth(nums1, 0, nums2, 0, len / 2) +
						find_kth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
			}
		}

	private:
		double find_kth(vector<int>& nums1, int i, vector<int>& nums2, int j, int k) {
			int m = nums1.size();
			int n = nums2.size();

			if (m-i > n-j) {
				return find_kth(nums2, j, nums1, i, k);
			}

			if (i >= m) {
				return nums2[j+k-1];
			}

			if (k == 1) {
				return min(nums1[i], nums2[j]);
			}

			int idx1 = min(m, i + k/2);
			int idx2 = j + k - (idx1 - i);

			if (nums1[idx1 - 1] > nums2[idx2 - 1]) {
				return find_kth(nums1, i, nums2, idx2, k - (idx2 - j));
			} else {
				return find_kth(nums1, idx1, nums2, j, k - (idx1 - i));
			}
		}
};
