/*
 * Filename: RomantoInteger.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 03:41:17 PM EDT
 */

public class Solution {
	public int romanToInt(String s) {
		int ret = 0;

		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case 'I':
					if (i < s.length() - 1) {
						switch(s.charAt(i+1)) {
							case 'V':
								ret += 4;
								i++;
								break;
							case 'X':
								ret += 9;
								i++;
								break;
							default:
								ret++;
								break;
						}
					} else {
						ret++;
					}
					break;
				case 'V':
					ret += 5;
					break;
				case 'X':
					if (i < s.length() - 1) {
						switch(s.charAt(i+1)) {
							case 'L':
								ret += 40;
								i++;
								break;
							case 'C':
								ret += 90;
								i++;
								break;
							default:
								ret += 10;
								break;
						}
					} else {
						ret += 10;
					}
					break;
				case 'L':
					ret += 50;
					break;
				case 'C':
					if (i < s.length() - 1) {
						switch(s.charAt(i+1)) {
							case 'D':
								ret += 400;
								i++;
								break;
							case 'M':
								ret += 900;
								i++;
								break;
							default:
								ret += 100;
								break;
						}
					} else {
						ret += 100;
					}
					break;
				case 'D':
					ret += 500;
					break;
				case 'M':
					ret += 1000;
					break;
				default:
					break;
			}
		}

		return ret;
	}
}
