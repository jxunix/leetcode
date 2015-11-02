/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <iostream>
#include <map>
#include <string>
#include <vector>

#include "p.hpp"
#include "pr.hpp"
#include "valid_sudoku.cpp"

using namespace std;

Solution s;
P p;
Pr pr;

int main()
{
	string board_array[] = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
	vector<vector<char> > board;

	for (auto i : board_array)
	{
		vector<char> row (i.begin(), i.end());
		board.push_back(row);
	}

	p.print(board);
	cout << s.isValidSudoku(board) << endl;

	return 0;
}
