/** 
     ID: azklinu1
     LANG: C++11
     PROG: frac1
**/

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string.h>
#include <cmath>
#include <unordered_set>

#define pb push_back
#define mp make_pair

//#define pair<int, int> pii;

typedef long long ll;

using namespace std;

struct frac{
	int x;
	int y;
};

bool comp(frac a, frac b)
{
	return (double)a.x/(double)a.y < (double)b.x/(double)b.y;
}

double divide(frac a)
{
	return (double)a.x / (double)a.y;
}
vector<frac> v;
int main(){
	ifstream cin("frac1.in");
	ofstream cout("frac1.out");
	frac a;
	a.x = 0;
	a.y = 1;
	v.pb(a);
	int N; 
	cin >> N;
	unordered_set<double> set;
	for(int i = 1; i <= N; i++)
	{
		for(int j = 1; j <= N; j++)
		{
			//cout << "hi" << endl;
			if((i!=1 && i==j) || (i != 1 && j == 1) || (i > j)) continue;
			frac f;
			f.x = i;
			f.y = j;
			//cout << f.x << f.y << endl;
			if(!set.count(divide(f))){
				v.pb(f);
				set.insert(divide(f));
			}
		}
	}	
	sort(v.begin(), v.end(), comp);

	for(frac fr : v){
		cout << fr.x << "/" << fr.y << endl;
	}
}
