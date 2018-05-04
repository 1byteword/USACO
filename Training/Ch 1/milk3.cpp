/**
    ID: azklinu1
    LANG: C++11
    PROG: milk3
 **/

#include <iostream>
#include <fstream>

#include <vector>
#include <set>
#include <unordered_map>

#define pb push_back
#define FOR(i, a) for(int i = 0; i < a; i++)

using namespace std;

vector<int> v;
int cap[3];
bool seen[25][25][25] = {false};
bool val[21];
int t;
void dfs(int a, int b, int c)
{
	if(a==0){ val[c] = true; if(c > t) t = c; }
	if(seen[a][b][c]) return;
	seen[a][b][c] = true;
	//a>b
	if(a+b > cap[1]) dfs(a+b-cap[1], cap[1], c);		
	else dfs(0, a+b, c);
	//a>c
	if(a+c > cap[2]) dfs(a+c-cap[2], b, cap[2]);
	else dfs(0, b, a+c);
	//b>a
	if(b+a > cap[0]) dfs(cap[0], b+a-cap[0], c);
	else dfs(a+b, 0, c);
	//b>c
	if(b+c > cap[2]) dfs(a,b+c-cap[2],cap[2]);
	else dfs(a, 0, b+c);
	//c>a
	if(c+a > cap[0]) dfs(cap[0], b, c+a-cap[0]);
	else dfs(a+c, b, 0);
	//c>b
	if(c+b > cap[1]) dfs(a,cap[1],c+b-cap[1]);
	else dfs(a, b+c, 0);
}

int main()
{
	ifstream cin("milk3.in");
	ofstream cout("milk3.out");

	int a, b, c; cin >> a >> b >> c;
	t = 0;
	cap[0] = a;
	cap[1] = b;
	cap[2] = c;
	dfs(0, 0, c);
	FOR(i, sizeof(val))
	       	if(val[i]){ 
			if(i!=t) 
				cout << i << " ";
			else 
				cout << i;
	       		}
	cout << "" << endl;
}
