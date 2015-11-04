/*
 * Filename: sudoku_solver.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 03 Nov 2015 09:23:11 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution {
	public:
		void solveSudoku(vector<vector<char> >& board)
		{
			if (board.size() != 9 || board[0].size() != 9)
			{
				return;
			}

			solvableFrom(board, 0, 0);
		}

private:
		bool solvableFrom(
				vector<vector<char> >& board,
				int r,
				int c)
		{
			if (r == 9)
			{
				return true;
			}
			else if (c == 9)
			{
				return solvableFrom(board, r+1, 0);
			}
			else if (board[r][c] != '.')
			{
				return solvableFrom(board, r, c+1);
			}
			else
			{
				for (char p = '1'; p <= '9'; p++)
				{
					if (!isValid(board, r, c, p))
					{
						continue;
					}

					board[r][c] = p;
					if (solvableFrom(board, r, c+1) &&
							isFull(board))
					{
						return true;
					}
				}

				board[r][c] = '.';
			}
		}

		bool isValid(
				vector<vector<char> >& board,
				int r,
				int c,
				char p)
		{
			for (int i = 0; i < 9; i++)
			{
				if (board[i][c] == p || board[r][i] == p)
				{
					return false;
				}
			}

			int index = r / 3 * 3 + c / 3;
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (board[index / 3 * 3 + i][index % 3 * 3 + j] == p)
					{
						return false;
					}
				}
			}

			return true;
		}

		bool isFull(
				vector<vector<char> >& board)
		{
			for (auto i = 0; i < 9; i++)
			{
				for (auto j = 0; j < 9; j++)
				{
					if (board[i][j] < '0' || board[i][j] > '9')
					{
						return false;
					}
				}
			}

			return true;
		}
};
