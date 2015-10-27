/*
 * Filename: ReverseWordsinaString.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 01:24:24 PM EDT
 */

public class Solution {
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		} 
		
		if (s.equals("")) {
			return s;
		}

		s = s.trim();
		String[] words = s.split(" +");
		String res = "";

		for (int i = words.length - 1; i >= 0; i--) {
			res += " ";
			res += words[i];
		}

		return res.substring(1);
	}
}
