/*
 * Filename: TheSkylineProblem.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 07:41:49 PM EDT
 */

public class Solution {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<int[]>();

		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return res;
		}

		List<Edge> edges = new ArrayList<Edge>();

		for (int[] building : buildings) {
			edges.add(new Edge(building[0], building[2], true));
			edges.add(new Edge(building[1], building[2], false));
		}

		Collections.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a, Edge b) {
				if (a.x != b.x) {
					return Integer.compare(a.x, b.x);
				}

				if (a.isLeft && b.isLeft) {
					return Integer.compare(b.h, a.h);
				}

				if (!a.isLeft && !b.isLeft) {
					return Integer.compare(a.h, b.h);
				}

				return a.isLeft ? -1 : 1;
			}
		});

		PriorityQueue<Integer> hheap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

		for (Edge e : edges) {
			if (e.isLeft) {
				if (hheap.isEmpty() || e.h > hheap.peek()) {
					res.add(new int[]{ e.x, e.h });
				}

				hheap.add(e.h);
			} else {
				hheap.remove(e.h);

				if (hheap.isEmpty()) {
					res.add(new int[]{ e.x, 0 });
				} else if (e.h > hheap.peek()) {
					res.add(new int[]{ e.x, hheap.peek() });
				}
			}
		}

		return res;
	}

	class Edge {
		int x;
		int h;
		boolean isLeft;

		public Edge(int x, int h, boolean isLeft) {
			this.x = x;
			this.h = h;
			this.isLeft = isLeft;
		}
	}
}
