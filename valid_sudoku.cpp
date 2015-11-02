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
		bool isValidSudoku(vector<vector<char> >& board)
		{
			return isValidPerRow(board) && isValidPerCol(board) && isValidPerGrid(board);
		}

	private:
		bool isValidPerRow(vector<vector<char> >& board)
		{
			for (auto r : board)
			{
				if (!isValidRow(r))
				{
					return false;
				}
			}

			return true;
		}

		bool isValidRow(vector<char>& row)
		{
			map<char, int> mapping;

			for (auto i : row)
			{
				if (i == '.')
				{
					continue;
				}
				else if (i >= '1' && i <= '9')
				{
					if (mapping[i] > 1)
					{
						return false;
					}
					else
					{
						mapping[i]++;
					}
				}
				else
				{
					return false;
				}
			}

			return true;
		}

		bool isValidPerCol(vector<vector<char> >& board)
		{
			for (auto c : board)
			{
				if (!isValidCol(c))
				{
					return false;
				}
			}

			return true;
		}

		bool isValidCol(vector<char>& col)
		{
			map<char, int> mapping;

			for (auto i : col)
			{
				if (i == '.')
				{
					continue;
				}
				else if (i >= '1' && i <= '9')
				{
					if (mapping[i] > 1)
					{
						return false;
					}
					else
					{
						mapping[i]++;
					}
				}
				else
				{
					return false;
				}
			}

			return true;
		}

		bool isValidPerGrid(vector<vector<char> >& board)
		{
			for (auto g : board)
			{
				if (!isValidGrid(g))
				{
					return false;
				}
			}

			return true;
		}

		bool isValidGrid(vector<char>& grid)
		{
			map<char, int> mapping;

			for (auto i : grid)
			{
				if (i == '.')
				{
					continue;
				}
				else if (i >= '1' && i <= '9')
				{
					if (mapping[i] > 1)
					{
						return false;
					}
					else
					{
						mapping[i]++;
					}
				}
				else
				{
					return false;
				}
			}

			return true;
		}
};
