/*
 * Filename: TextJustification.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 22 May 2015 12:14:26 PM EDT
 */

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		List<String> line = new ArrayList<String>();

		if (words == null || words.length == 0) {
			return res;
		}

		if (maxWidth == 0) {
			if (words.length == 1 && words[0].equals("")) {
				res.add("");
				return res;
			} else {
				return res;
			}
		}

		int width = 0;
		int count = 0;

		for (int i = 0; i < words.length; i++) {
			if (width + words[i].length() > maxWidth) {
				int numSpace = maxWidth - width + 1;
				String str = "";

				if (count == 1) {
					for (String s: line) {
						str = str.concat(s);
					}

					for (int j = 0; j < numSpace; j++) {
						str = str.concat(" ");
					}
				} else {
					int a = numSpace / (count - 1);
					int b = numSpace % (count - 1);
					int j = 0;

					for (; j < b; j++) {
						str = str.concat(line.get(j));
						if (j != line.size() - 1) {
							for (int k = 0; k <= a + 1; k++) {
								str = str.concat(" ");
							}
						}
					}

					for (; j < line.size(); j++) {
						str = str.concat(line.get(j));
						if (j != line.size() - 1) {
							for (int k = 0; k <= a; k++) {
								str = str.concat(" ");
							}
						}
					}
				}

				res.add(str);
				width = 0;
				count = 0;
				line.clear();
			}

			line.add(words[i]);
			width += words[i].length() + 1;
			count++;
		}

		int numSpace = maxWidth - width + 1;
		String str = "";

		if (count == 1) {
			for (String s: line) {
				str = str.concat(s);
			}

			for (int i = 0; i < numSpace; i++) {
				str = str.concat(" ");
			}
		} else {
			for (String s: line) {
				str = str.concat(s);
				str = str.concat(" ");
			}

			for (int i = 0; i < numSpace - 1; i++) {
				str = str.concat(" ");
			}
		}

		res.add(str);
		return res;
	}
}
