/*
 * Filename: FractiontoRecurringDecimal.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 15 Jul 2015 03:17:06 PM EDT
 */

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}

		if (denominator == 0) {
			return "";
		}
		
		String res = "";
		if ((numerator > 0 && denominator < 0)
				|| (numerator < 0 && denominator > 0)) {
			res += "-";
		}

		long num = Math.abs((long) numerator);
		long denom = Math.abs((long) denominator);

		System.out.println(num);
		System.out.println(denom);

		long quotient = num / denom;
		num = (num % denom) * 10;
		res += quotient;

		if (num == 0) {
			return res;
		}

		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		res += ".";

		while (num != 0) {
			if (map.containsKey(num)) {
				int i = map.get(num);
				return res.substring(0, i) + "(" + res.substring(i) + ")";
			}
			
			map.put(num, res.length());
			quotient = num / denom;
			num = (num % denom) * 10;
			res += quotient;
		}

		return res;
	}
}
