/*
 * Filename: main.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

#include "aux.h"
#include "substring_with_concatenation_of_all_words.cc"

using namespace std;

Solution s;
Aux aux;

int main()
{
	string str = "barfoothefoobarman";
	string words[] = { "foo", "bar" };
	vector<string> v (words, words + sizeof(words) / sizeof(words[0]));
	
	vector<int> res = s.findSubstring(str, v);
	aux.print1d(res);

	return 0;
}
