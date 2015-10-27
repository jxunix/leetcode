/*
 * Filename: Aux.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 28 Jun 2015 11:58:08 AM EDT
 */

public class Aux {
	public static void print(int[] A) {
		System.out.print("[ ");
		for (int a: A) {
			System.out.format("%2d ", a);
		}
		System.out.println("]");
	}

	public static void print(Integer[] A) {
		System.out.print("[ ");
		for (Integer a: A) {
			System.out.print(a + " ");
		}
		System.out.println("]");
	}

	public static void print(boolean[] A) {
		System.out.print("[ ");
		for (boolean a: A) {
			if (a) {
				System.out.print(" T ");
			} else {
				System.out.print(" F ");
			}
		}
		System.out.println("]");
	}

	public static void print(String[] A) {
		System.out.print("[ ");
		for (String a: A) {
			System.out.print(a + " ");
		}
		System.out.println("]");
	}

	public static void print(int[][] A) {
		System.out.println("[");
		for (int i = 0; i < A.length; i++) {
			System.out.print("   ");
			for (int j = 0; j < A[i].length; j++) {
				System.out.printf("%3d ", A[i][j]);
			}
			System.out.println();
		}
		System.out.println("]");
	}

	public static void print(char[][] A) {
		System.out.println("[");
		for (int i = 0; i < A.length; i++) {
			System.out.print("   ");
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(" " + A[i][j]);
			}
			System.out.println();
		}
		System.out.println("]");
	}

	public static void print(boolean[][] A) {
		System.out.println("[");
		for (int i = 0; i < A.length; i++) {
			System.out.print("   ");
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j]) {
					System.out.print(" T");
				} else {
					System.out.print(" F");
				}
			}
			System.out.println();
		}
		System.out.println("]");
	}
}
