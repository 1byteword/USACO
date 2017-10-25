/**
     ID: azklinu1
     LANG: C++11
     PROG: castle
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

int n, m;
int room = 0;
int id[55][55];
int actual[55][55];
int rooms[2505];
bool visited[55][55];

bool inb(int x, int y)
{
	return x >= 0 && x < m && y >= 0 && y < n;
}

bool wall(int at, int dir)
{
	return (at&dir) == dir;
}

void dfs(int x, int y, int room)
{
	if(visited[x][y]) return;
	visited[x][y] = true;
	id[x][y] = room;
	rooms[room]++;
	int at = actual[x][y];
	if(!wall(at, 1)){ //west
		if(inb(x, y-1)){
			dfs(x, y-1, room);
		}
	}
	if(!wall(at, 2)){ //north
		if(inb(x-1, y)){
			dfs(x-1, y, room);
		}
	}
	if(!wall(at, 4)){ //east
		if(inb(x, y+1)){
		       	dfs(x, y+1, room);
		}
	}
	if(!wall(at, 8)){ //south
		if(inb(x+1, y)){
			dfs(x+1, y, room);
		}
	}
}

void flood(){
	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			if(!visited[i][j]){
				dfs(i, j, room);
				room++;
			}
		}
	}
}

int main()
{
	ifstream cin("castle.in");
	ofstream cout("castle.out");

	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cin >> actual[i][j];
		}
	}
	flood();
	cout << room << endl;
	
	int lim = -1;
	for(int i = 0; i < room; i++)
	{
		lim = max(lim, rooms[i]);
	}
	cout << lim << endl;
	
	int largest_room = -1;
	string bound = "";

	for(int j = 0; j < n; j++){
	for(int i = m-1; i >= 0; i--)
		{
			int at = actual[i][j];
			int above = id[i-1][j];
			int right = id[i][j+1];
			if(inb(i-1, j) && wall(at, 2) && above != id[i][j] && rooms[above]+rooms[id[i][j]] > largest_room)
			{
				largest_room = rooms[above]+rooms[id[i][j]];
				bound = "" + to_string(i+1) + " " + to_string(j+1) + " N";	
			}

			if(inb(i, j+1) && wall(at, 4) && right != id[i][j] && rooms[right]+rooms[id[i][j]] > largest_room)
			{
				largest_room = rooms[right]+rooms[id[i][j]];	
				bound = "" + to_string(i+1) + " " + to_string(j+1) + " E";
			}
		}
	}
	cout << largest_room << endl;
	cout << bound << endl;
}
