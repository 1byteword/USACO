/*
  ID: azklinu1
  PROG: wormhole
  LANG: C++
*/
#include <fstream>
#include <iostream>
using namespace std;

#define MAXN 12
int N, X[MAXN+1], Y[MAXN+1];
int partner[MAXN+1];
int nor[MAXN+1];
bool cycle()
{	
	for (int start=1; start<=N; start++) {
		    int pos = start;
		    for (int count=0; count<N; count++)
		    	pos = nor[partner[pos]];
		    if (pos != 0) return true;
	}
	return false;
}

int solve()
{
	int i = 0;
	int ans = 0;
	for(i = 1; i <= N; i++)
		if(partner[i] == 0) break;
	
	if(i > N) {
		if(cycle()) return 1;
		else return 0;
		
	}
	for(int j = i+1; j <= N; j++)
		if(partner[j] == 0)
		{
			partner[i] = j;
			partner[j] = i;
			ans += solve();
			partner[i] = partner[j] = 0;
		}	
	return ans;
}

int main()
{
	ifstream cin("wormhole.in");
	ofstream cout("wormhole.out");
	cin >> N;
	for(int a = 1; a <= N ; a++) cin >> X[a] >> Y[a];
	for (int i=1; i<=N; i++) // set next_on_right[i]...
	for (int j=1; j<=N; j++)
		if (X[j] > X[i] && Y[i] == Y[j]) // j right of i...
			if (nor[i] == 0 || X[j]-X[i] < X[nor[i]]-X[i])
				nor[i] = j;

	cout << solve() << "\n";
}
