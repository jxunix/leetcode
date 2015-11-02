/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <iostream>
#include <string>
#include <vector>
#include "aux.hpp"
#include "valid_sudoku.cpp"

using namespace std;

Solution s;
Aux aux;

int main()
{
	string board_array[] = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
	vector<vector<char> > board;

	for (auto i : board_array)
	{
		vector<char> row (i.begin(), i.end());
		board.push_back(row);
	}

	aux.print(board);

	return 0;
}
