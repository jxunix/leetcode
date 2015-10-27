/*
 * Filename: CloneGraph.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 03:15:12 PM EDT
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);

		UndirectedGraphNode node2 = new UndirectedGraphNode(node.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map =
			new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, node2);

		while (!queue.isEmpty()) {
			UndirectedGraphNode p = queue.poll();
			List<UndirectedGraphNode> nbrs2 = map.get(p).neighbors;

			if (p == null) {
				continue;
			}

			for (UndirectedGraphNode q: p.neighbors) {
				if (map.containsKey(q)) {
					nbrs2.add(map.get(q));
				} else {
					UndirectedGraphNode q2 = new UndirectedGraphNode(q.label);
					nbrs2.add(q2);
					map.put(q, q2);
					queue.add(q);
				}
			}
		}

		return node2;
	}
}
