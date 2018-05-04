/** 
    ID: azklinu1
    LANG: C++11
    PROG: crypt1
**/

#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <set>
#include <unordered_map>


#define FOR(i, a) for(int i = 0; i < a; i++)

using namespace std;

set<int> aset;
bool check(int a, int b, int c, int d, int e)
{
	int abc = (100*a) + (10*b) + c;
	int de = (10*d) + e;
	int part1 = abc*e;
	int part2 = abc*d;
	int sum = abc*de;
	if(part1 >= 1000 || part2 >= 10000 || sum >= 10000) return false;
	while(part1 > 0)
	{
		if(!aset.count(part1%10)) return false;
		part1/=10;
	}
	while(part2 > 0)
	{
		if(!aset.count(part2%10)) return false;
	 	part2/=10;
	}
	while(sum > 0)
	{
		if(!aset.count(sum%10)) return false;
		sum/=10;
	}
	return true;	
}

int main()
{
	ifstream cin("crypt1.in");
	ofstream cout("crypt1.out");
	int N; cin >> N;
	int arr[N];
	FOR(i,N)
	{
		cin >> arr[i];
		aset.insert(arr[i]);
	}	
	int count= 0;
	for(int a = 0; a < N; a++)
	{
		int A = arr[a];
		for(int b = 0; b < N; b++)
		{
			int B = arr[b];
			for(int c = 0; c < N; c++)
			{
				int C = arr[c];
				for(int d = 0; d < N; d++)
				{
					int D = arr[d];
					for(int e = 0; e < N; e++)
					{ 
						int E = arr[e];
						if(check(A, B, C, D, E))count++;
					}					
				}
			}
		}
	}
	cout << count << endl;
}

