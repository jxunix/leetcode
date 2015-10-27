/*
 * Filename: LetterCombinationsofaPhoneNumber.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Thu 12 Mar 2015 02:14:34 PM EDT
 */

public class Solution {
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<String>();
		}

		for (int i = 0; i < digits.length(); i++) {
			if (digits.charAt(i) > '9' || digits.charAt(i) < 2) {
				return new ArrayList<String>();
			}
		}

		String[] ref = new String[]{
			"abc",
			"def",
			"ghi",
			"jkl",
			"mno",
			"pqrs",
			"tuv",
			"wxyz"
		};

		return letterCombinations(digits, 0, ref);
	}

	private List<String> letterCombinations(String digits, int n, String[] ref) {
		List<String> ret = new ArrayList<String>();

		if (digits.length() == n) {
			ret.add("");
			return ret;
		}

		List<String> retRec = letterCombinations(digits, n+1, ref);
		int digit = (int) digits.charAt(n) - '0';

		for (int i = 0; i < ref[digit - 2].length(); i++) {
			for (int j = 0; j < retRec.size(); j++) {
				String s = Character.toString(ref[digit - 2].charAt(i));
				s = s.concat(retRec.get(j));
				ret.add(s);
			}
		}

		return ret;
	}
}
