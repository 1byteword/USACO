/** 
    ID: azklinu1
    LANG: C++
    PROG: ariprog
**/

//#include <iostream>
#include <fstream>
#include <algorithm>
//#include <unordered_map>
#include <vector>
//#include <unordered_set>
using namespace std;

typedef long long ll;
#define pii pair<int,int> 

#define FOR(i, a) for(int i = 0; i < a; i++)
#define maxn 1e9

#define pb push_back
#define mp make_pair

vector<int> v;
vector<pair<int, int> > pv;
bool arr[125001];

bool comp(pair<int, int> a, pair<int, int> b)
{
	if(a.second == b.second) return a.first < b.first;
	return a.second < b.second;
}

int main()
{
	ifstream cin("ariprog.in");
	ofstream cout("ariprog.out");

	int N, M; cin >> N >> M;
	for(int p = 0; p <= M; p++)
	{
		for(int q = p; q <= M; q++)
		{
			int bi = (p*p) + (q*q);
			if(!arr[bi]){
				v.pb(bi);
				arr[bi] = true;
			}
		}
	}
	sort(v.begin(), v.end());
	for(int i = 0; i < v.size(); i++)
	{
		int a = v[i];
		int f = 0;
		for(int j = i+1; j < v.size(); j++)
		{
			bool bo = true;
			int b = v[j];
			int diff = b-a;
			if(diff > 3000) continue;
			if(a+((N-1)*diff) > M*M*2) continue;
			for(int k = 2; k < N; k++)
			{
				b+=diff;
				if(!(arr[b])){ bo = false; break;}
			}
			//point
			if(bo){pv.pb(mp(a,diff));}
		}
	}
	if(pv.size() == 0){ cout << "NONE" << endl; return 0;}
	sort(pv.begin(), pv.end(), comp);
	for(int i = 0; i < pv.size(); i++)
	{
		cout << pv[i].first << " " << pv[i].second << endl;
	}
}
