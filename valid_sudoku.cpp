/*
 * Filename: valid_sudoku.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 01 Nov 2015 10:24:08 PM EST
 * Description: 
 */

#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
	public:
		bool isValidSudoku(vector<vector<char> > &board)
		{
			map<char, bool> row;
			map<char, bool> col;
			map<char, bool> block;

			for (size_t i = 0; i < 9; i++)
			{
				col.clear();
				row.clear();

				for (size_t j = 0; j < 9; j++)
				{
					if (board[i][j] != '.')
					{
						if (col[board[i][j]])
						{
							return false;
						}
						else
						{
							col[board[i][j]] = true;
						} 
					}

					if (board[j][i] != '.')
					{
						if (row[board[j][i]])
						{
							return false;
						}
						else
						{
							row[board[j][i]] = true;
						} 
					}
				}
			}

			for (size_t ii = 0; ii < 9; ii += 3)
			{
				for (size_t jj = 0; jj < 9; jj += 3)
				{
					block.clear();

					for (size_t i = ii; i < ii+3; i++)
					{
						for (size_t j = jj; j < jj+3; j++)
						{
							if (board[i][j] != '.')
							{
								if (block[board[i][j]])
								{
									return false;
								}
								else
								{
									block[board[i][j]] = true;
								} 
							}
						}
					}        
				}
			}

			return true;
		}
};
