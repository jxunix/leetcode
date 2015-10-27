/*
 * Filename: IntegertoRoman.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 02:13:11 PM EDT
 */

public class Solution {
	public String intToRoman(int num) {
		String ret = "";
		int i = 0;

		while (num >= 1000) {
			num -= 1000;
			ret += "M";
		}

		if (num >= 900) {
			num -= 900;
			ret += "CM";
		} else if (num >= 500) {
			num -= 500;
			ret += "D";
		} else if (num >= 400) {
			num -= 400;
			ret += "CD";
		}

		while (num >= 100) {
			num -= 100;
			ret += "C";
		}

		if (num >= 90) {
			num -= 90;
			ret += "XC";
		} else if (num >= 50) {
			num -= 50;
			ret += "L";
		} else if (num >= 40) {
			num -= 40;
			ret += "XL";
		}

		while (num >= 10) {
			num -= 10;
			ret += "X";
		}

		if (num >= 9) {
			num -= 9;
			ret += "IX";
		} else if (num >= 5) {
			num -= 5;
			ret += "V";
		} else if (num >= 4) {
			num -= 4;
			ret += "IV";
		}

		while (num >= 1) {
			num -= 1;
			ret += "I";
		}

		return ret;
	}
}
