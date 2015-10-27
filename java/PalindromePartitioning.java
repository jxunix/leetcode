/*
 * Filename: PalindromePartitioning.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 01 Jul 2015 02:50:04 PM EDT
 */

public class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();

		if (s == null || s.length() == 0) {
			return res;
		}

		partitionAux(s, 0, list, res);
		return res;
	}

	private void partitionAux(String s, int i, List<String> list, List<List<String>> res) {
		if (i == s.length()) {
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int j = i; j < s.length(); j++) {
			if (isPalindrome(s, i, j)) {
				list.add(s.substring(i, j+1));
				partitionAux(s, j+1, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}
}
