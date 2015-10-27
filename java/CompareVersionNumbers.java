/*
 * Filename: CompareVersionNumbers.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 18 Jun 2015 12:01:04 PM CST
 */

public class Solution {
	public int compareVersion(String version1, String version2) {
		String[] versions1 = version1.split("\\.");
		String[] versions2 = version2.split("\\.");

		int[] e1 = new int[versions1.length];
		int[] e2 = new int[versions2.length];

		for (int i = 0; i < versions1.length; i++) {
			e1[i] = Integer.parseInt(versions1[i]);
		}

		for (int i = 0; i < versions2.length; i++) {
			e2[i] = Integer.parseInt(versions2[i]);
		}

		int length = Math.min(e1.length, e2.length);
		for (int i = 0; i < length; i++) {
			if (e1[i] > e2[i]) {
				return 1;
			} else if (e1[i] < e2[i]) {
				return -1;
			}
		}

		if (e1.length > e2.length) {
			for (int i = e2.length; i < e1.length; i++) {
				if (e1[i] != 0) {
					return 1;
				}
			}
		} else if (e1.length < e2.length) {
			for (int i = e1.length; i < e2.length; i++) {
				if (e2[i] != 0) {
					return -1;
				}
			}
		}

		return 0;
	}
}
