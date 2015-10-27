/*
 * Filename: CourseSchedule.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 04:51:40 PM EDT
 */

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
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

		for (int i = 0; i < numCourses; i++) {
			if (visited[i] == 0) {
				if (!canFinishAux(i, map, visited)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean canFinishAux(int i, HashMap<Integer, List<Integer>> map, int[] visited) {
		if (visited[i] == 1) {
			return false;
		} else if (visited[i] == 0) {
			visited[i] = 1;

			if (map.containsKey(i)) {
				for (int j : map.get(i)) {
					if (!canFinishAux(j, map, visited)) {
						return false;
					}
				}
			}

			visited[i] = 2;
		}

		return true;
	}
}
