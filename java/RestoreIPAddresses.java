/*
 * Filename: RestoreIPAddresses.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 28 May 2015 07:50:08 PM EDT
 */

public class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();

		if (s == null) {
			return res;
		}

		int len = s.length();
		if (len > 12 || len < 4) {
			return res;
		}

		int i = 0;
		int j = 1;
		int[] lens = new int[4];

		while (true) {
			if (j == 4) {
				if (i > 0) {
					i--;
					j = lens[i] + 1;
				} else {
					return res;
				}
			} else {
				if (test(lens, s, i, j)) {
					int tmp = lens[i];
					lens[i] = j;
					if (i == 3) {
						save(lens, s, res);
						lens[i] = tmp;
						j++;
					} else {
						i++;
						j = 1;
					}
				} else {
					j++;
				}
			}
		}
	}

	private boolean test(int[] lens, String s, int i, int j) {
		if (i == 3) {
			if (lens[0] + lens[1] + lens[2] + j != s.length()) {
				return false;
			}
		}

		int idx = 0;
		for (int k = 0; k < i; k++) {
			idx += lens[k];
		}

		if (idx + j > s.length()) {
			return false;
		}

		String num = s.substring(idx, idx + j);
		int number = Integer.parseInt(num);
		boolean res = true;

		if (nums.length() == 2) {
			res = (number >= 10);
		} else if (num.length() == 3) {
			res = (number >= 100 && number <= 255);
		}

		return res;
	}

	private void save(int[] lens, String s, List<String> res) {
		int idx = 0;
		String ip = s.substring(idx, idx + lens[0]);
		ip = ip.concat(".");
		idx += lens[0];
		ip = ip.concat(s.substring(idx, idx + lens[1]));
		ip = ip.concat(".");
		idx += lens[1];
		ip = ip.concat(s.substring(idx, idx + lens[2]));
		ip = ip.concat(".");
		idx += lens[2];
		ip = ip.concat(s.substring(idx));
		res.add(ip);
	}
}
