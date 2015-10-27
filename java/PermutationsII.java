/*
 * Filename: PermutationsII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 12 May 2015 11:17:08 AM EDT
 */

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> perm = new ArrayList<Integer>();

		if (nums == null || nums.length == 0) {
			return list;
		}

		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];  
		permuteUniqueAux(nums, list, perm, visited);
		return list;
	}

	public void permuteUniqueAux(int[] nums, List<List<Integer>> list, List<Integer> perm, boolean[] visited){
		System.out.println(visited);
		if (perm.size() == nums.length){
			list.add(new ArrayList<Integer>(perm));
			return;
		}

		for (int i = 0; i < nums.length; i++){
			if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
				continue;
			}

			if (!visited[i]) {
				perm.add(nums[i]);
				visited[i] = true;
				permuteUniqueAux(nums, list, perm, visited);
				perm.remove(perm.size() - 1);
				visited[i] = false;
			}
		}
	}
}
