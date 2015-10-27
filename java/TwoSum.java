/*
 * Filename: TwoSum.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Tue 03 Mar 2015 12:21:05 AM EST
 */

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				res[0] = 1 + map.get(target - numbers[i]);
				res[1] = 1 + i;
				return res;
			}
			map.put(numbers[i], i);
		}

		return res;
	}
}
