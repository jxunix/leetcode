/*
 * Filename: GasStation.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 04:53:09 PM EDT
 */

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int ssum = 0;
		int idx = 0;

		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			ssum += gas[i] - cost[i];

			if (ssum < 0) {
				idx = i+1;
				ssum = 0;
			}
		}

		if (sum < 0) {
			return -1;
		}

		return idx;
	}
}
