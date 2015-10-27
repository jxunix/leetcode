/*
 * Filename: LRUCache.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 17 Jul 2015 08:34:36 PM EDT
 */

public class LRUCache {
	HashMap<Integer, Node> map;
	int capacity;
	int size;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Node>();
		this.capacity = capacity;
		size = 0;
		head = null;
		tail = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			addHead(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int val) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.val = val;
			remove(node);
			addHead(node);
		} else {
			Node node = new Node(key, val);

			if (size == capacity) {
				map.remove(tail.key);
				remove(tail);
				addHead(node);
			} else {
				addHead(node);
				size++;
			}

			map.put(key, node);
		}
	}

	private void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}

		if (node.next == null) {
			tail = node.prev;
		} else {
			node.next.prev = node.prev;
		}
	}

	private void addHead(Node node) {
		if (head == null) {
			node.prev = null;
			node.next = head;
			head = node;
		} else {
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
		}

		if (tail == null) {
			tail = node;
		}
	}

	class Node {
		int key;
		int val;
		Node prev;
		Node next;

		public Node (int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
