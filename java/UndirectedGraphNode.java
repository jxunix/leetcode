/*
 * Filename: UndirectedGraphNode.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 03:15:58 PM EDT
 */

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
