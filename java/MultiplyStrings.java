/*
 * Filename: MultiplyStrings.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 11 May 2015 12:36:47 PM EDT
 */

public class Solution {
	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0) {
			return null;
		}

		if (num2 == null || num2.length() == 0) {
			return null;
		}

		String ret = "";
		String prod;

		for (int i = num2.length() - 1; i >= 0; i--) {
			prod = multiplyAux(num1, num2.charAt(i) - '0');
			for (int j = 0; j < num2.length() - 1 - i; j++) {
				prod = prod.concat("0");
			}
			
			ret = add(ret, prod);
		}

		while (ret.charAt(0) == '0' && ret.length() > 1) {
			ret = ret.substring(1);
		}

		return ret;
	}

	private String add(String num1, String num2) {
		if (num1.length() == 0) {
			return num2;
		}
		
		if (num2.length() == 0) {
			return num1;
		}

		if (num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		int i;
		int digit1;
		int digit2;
		int digit = 0;
		int carry = 0;
		String ret = "";

		for (i = num1.length() - 1; i >= num1.length() - num2.length(); i--) {
			digit1 = num1.charAt(i) - '0';
			digit2 = num2.charAt(i + num2.length() - num1.length()) - '0';

			digit = digit1 + digit2 + carry;
			carry = digit / 10;
			digit %= 10;
			ret = Integer.toString(digit).concat(ret);
		}

		for (; i >= 0; i--) {
			digit1 = num1.charAt(i) - '0';
			digit = digit1 + carry;
			carry = digit / 10;
			digit %= 10;
			ret = Integer.toString(digit).concat(ret);
		}

		if (carry != 0) {
			ret = Integer.toString(carry).concat(ret);
		}

		return ret;
	}

	private String multiplyAux(String num1, int digit2) {
		if (digit2 == 0) {
			return "0";
		}

		int digit1;
		int digit = 0;
		int carry = 0;
		String ret = "";

		for (int i = num1.length() - 1; i >= 0; i--) {
			digit1 = num1.charAt(i) - '0';
			digit = digit1 * digit2 + carry;
			carry = digit / 10;
			digit %= 10;
			ret = Integer.toString(digit).concat(ret);
		}

		if (carry != 0) {
			ret = Integer.toString(carry).concat(ret);
		}

		return ret;
	}
}
