/*
 * Filename: Permutations.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 11 May 2015 05:14:32 PM EDT
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null) {
			return null;
		}

		return permuteAux(nums, 0, new ArrayList<List<Integer>>());
	}

	private List<List<Integer>> permuteAux(int[] nums, int i, List<List<Integer>> list) {
		if (i > nums.length - 1) {
			return list;
		}

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (i == 0) {
			List<Integer> perm = new ArrayList<Integer>();
			perm.add(nums[i]);
			ret.add(perm);
		} else {
			for (List<Integer> perm: list) {
				for (int j = perm.size(); j >= 0; j--) {
					List<Integer> permCpy = new ArrayList<Integer>(perm);
					permCpy.add(j, nums[i]);
					ret.add(permCpy);
				}
			}
		}

		return permuteAux(nums, i+1, ret);
	}
}
