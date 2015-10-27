/*
 * Filename: RemoveElement.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 05:17:43 PM EDT
 */

public class Solution {
	public int removeElement(int[] A, int elem) {
		int ret = A.length;

		for (int i = 0; i < ret;) {
			if (A[i] == elem && A[ret-1] != elem) {
				A[i] = A[ret-1];
				ret--;
				i++;
			} else if (A[i] == elem && A[ret-1] == elem) {
				ret--;
			} else {
			    i++;
			}
		}

		return ret;
	}
}
