/**
     ID: azklinu1
     LANG: C++11
     PROG: holstein
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

int kth(int n, int k)
{
	return (n & (1<<k))>>(k);
}

int main(){

	ifstream cin("holstein.in");
	ofstream cout("holstein.out");

	int v; cin >> v;
	int arr[v];
	for(int i = 0; i < v; i++)
	{
		cin >> arr[i];
	}

	int g; cin >> g;
	int vita[g][v];
	for(int i = 0; i < g; i++)
	{
		for(int j = 0; j < v; j++)
		{
			cin >> vita[i][j];
		}
	}

	vector<int> goodscoop;
	int min_size = INT_MAX;
	for(int i = 0; i < (1<<g); i++)
	{
		int current_scoop[v];
		memset(current_scoop, 0, sizeof current_scoop);
		vector<int> scoops;
		int index;
		for(int j = 0; j < g; j++)
		{
			int spook = kth(i,j);
			index = 0;
			if(spook != 0)
			{
				scoops.pb(j+1);
				for(int a : vita[j])
				{
					current_scoop[index++] += a;
				}
			}
			index = 0;
		}
		bool valid = true;
		for(int b : current_scoop)
		{
			if(b < arr[index++])
			{
				valid = false;	
			}
		}	
		if(valid && scoops.size() < min_size)
		{
			goodscoop = scoops;
			min_size = scoops.size();
		}
	}

	cout << min_size << " ";
	for(int i = 0; i < goodscoop.size(); i++)
	{
		int a = goodscoop[i];
		if(i!=goodscoop.size()-1)cout << a << " ";
		else cout << a << endl;
	}
}
