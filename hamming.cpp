/**
     ID: azklinu1
     LANG: C++11
     PROG: hamming
**/
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <cmath>
#include <climits>
#include <queue>

typedef long long ll;

#define pb push_back
#define mp make_pair

using namespace std;

vector<int> values;
int n, b, d;
int distance(int a, int b)
{
	return __builtin_popcount(a^b);
}

int main(){
	ifstream cin("hamming.in");
	ofstream cout("hamming.out");
	cin>>n>>b>>d;
	
	for(int i = 0; i < pow(2, b); i++)
	{
		bool boi = true;
		for(int a : values)
		{
			if(distance(a, i) < d)
			{
				boi = false;
				break;
			}
		}
		if(boi) values.pb(i);
		if(values.size() == n) break;
	}

	for(int i = 0; i < values.size(); i++)
	{
		if(i%10==9 || i == values.size()-1) cout << values[i] << endl;
		else cout << values[i] << " ";
	}
}
