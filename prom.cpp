#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stdio.h>
#include <stack>

using namespace std;

#define pii pair<int, int>

vector<int> arr[10005];
int id[10005];
stack<int> s;
static int ans;
static int tally;

int dfs(int node)
{
	id[node] = tally++;
	s.push(node);
	int circle = id[node];
	for(int i : arr[node])
	{
		if(id[i] == -1)
		{
			circle = min(circle, dfs(i));
		}
		else
		{
			circle = min(circle, id[i]);
		}
	}

	if(circle == id[node])
	{
		int count = 1;
		while(s.top() != node)
		{	
			id[s.top()] = 100000;
			s.pop();
			count++;
		}
		s.pop();
		id[node] = 100000;
		if(count > 1) ans++;
	}
	return circle;
}

int main()
{
	ans = 0;
	int N, M; cin >> N >> M;

	for(int i = 0; i < M; i++)
	{
		int a, b; cin >> a >> b;
		a--; b--;
		arr[a].push_back(b);
	}
	for(int i = 0; i < N; i++)
	{
		id[i] = -1;
	}

	for(int i = 0; i < N; i++)
	{
		if(id[i] != -1) continue;
		dfs(i);
	}	
	cout << ans << endl;
	return 0;
}
