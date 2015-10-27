/*
 * Filename: rotate_image.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 26 Jul 2015 12:57:54 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		void rotate(vector<vector<int> >& matrix) {
			for (int i = 0, j = matrix.size() - 1; i < j; i++, j--)  {  
				for (int k = i, d = j; k < j; k++, d--) {  
					int t = matrix[i][k];  

					matrix[i][k] = matrix[d][i];  
					matrix[d][i] = matrix[j][d];  
					matrix[j][d] = matrix[k][j];  
					matrix[k][j] = t;  
				}  
			}
		}
};
