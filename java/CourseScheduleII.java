/*
 * Filename: CourseSchedule.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 04:51:40 PM EDT
 */

public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int[] visited = new int[numCourses];

		for (int[] edge : prerequisites) {
			if (map.containsKey(edge[0])) {
				map.get(edge[0]).add(edge[1]);
			} else {
				List<Integer> prereq = new ArrayList<Integer>();
				prereq.add(edge[1]);
				map.put(edge[0], prereq);
			}
		}

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				if (!canFinishAux(i, map, visited, list)) {
					return new int[0];
				}
			}
		}

		int[] order = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			order[list.size() - i - 1] = list.get(i);
		}

		return order;
	}

	private boolean canFinishAux(int i, HashMap<Integer, List<Integer>> map, int[] visited, List<Integer> list) {
		if (visited[i] == 1) {
			return false;
		} else if (visited[i] == 0) {
			visited[i] = 1;

			if (map.containsKey(i)) {
				for (int j : map.get(i)) {
					if (!canFinishAux(j, map, visited, list)) {
						return false;
					}
				}
			}

			visited[i] = 2;
			list.add(0, i);
		}

		return true;
	}
}
