/*
 * Filename: BasicCalculatorII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 14 Jul 2015 08:34:03 PM EDT
 */

public class Solution {
	public int calculate(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		int op = 1;
		int res = 0;
		int i = 0;

		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == ' ') {
				i++;
			} else if (c == '+' || c == '-') {
				if (!queue.isEmpty()) {
					int num = queue.poll();
					res = queue.peek() == 1 ? num + res : num - res;
					queue.remove();
				}

				op = c == '+' ? 1 : 2;
				int j = i+1;

				while (j < s.length()) {
					char c2 = s.charAt(j);

					if (c2 >= '0' && c2 <= '9' || c2 == ' ') {
						j++;
						continue;
					}

					break;
				}

				if (j != s.length() && (s.charAt(j) == '*' || s.charAt(j) == '/')) {
					queue.add(res);
					queue.add(op);
					res = Integer.parseInt(s.substring(i+1, j).trim());
				} else {
					int num = Integer.parseInt(s.substring(i+1, j).trim());
					res = op == 1 ? res + num : res - num;
				}

				i = j;
			} else if (c == '*' || c == '/') {
				op = c == '*' ? 3 : 4;
				i++;
			} else if (c >= '0' && c <= '9') {
				int num = c - '0';
				int j = i+1;

				while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
					num = num * 10 + (s.charAt(j) - '0');
					j++;
				}

				switch (op) {
					case 1:
						res += num;
						break;
					case 2:
						res -= num;
						break;
					case 3:
						res *= num;
						break;
					case 4:
						res /= num;
						break;
					default:
						break;
				}

				i = j;
			}
		}

		if (!queue.isEmpty()) {
			int num = queue.poll();
			res = queue.peek() == 1 ? num + res : num - res;
			queue.remove();
		}

		return res;
	}
}
