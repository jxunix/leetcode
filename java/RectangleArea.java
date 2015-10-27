/*
 * Filename: RectangleArea.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 05:37:12 PM CST
 */

public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int dn1 = Math.max(A, E);
		int dn2 = Math.max(B, F);
		int up1 = Math.min(C, G);
		int up2 = Math.min(D, H);
		
		int overlap = up1 >= dn1 && up2 >= dn2 ? (up1 - dn1) * (up2 - dn2) : 0;
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);

		return area1 + area2 - overlap;
	}
}
