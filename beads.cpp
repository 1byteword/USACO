/*
 ID: azklinu1
 PROG: beads
 LANG: C++
 */

#include <fstream>

using namespace std;

int main()
{
	ifstream cin("beads.in");
	ofstream cout("beads.out");
	int N = 0; cin >> N;
	int max = 0;
	string s; cin >> s;
	s += (s+s);
	for(int i = N; i < 2*N; i++)
	{
		int cur = 0;
		char l = 'w';
		char r = 'w';
		int q = i;
		int w = i+1;
		while(q >= 0)
		{
			if(l == 'w' && s[q] != 'w')
			{
				cur++;
				l = s[q];	
			}
			else if(s[q] == l || s[q] == 'w')
			{
				cur++;
			}
			else break;
			q--;
		}
		while(w<s.length())
		{	
			if(r == 'w' && s[w] != 'w')
			{
				cur++;
				r = s[w];
			}
			else if(s[w] == r || s[w] == 'w')
			{
				cur++;
			}
			else break;
			w++;
		}
		if(cur > max)
		{
			max = cur;
		}
	}
	max > N ? cout<<N<<endl : cout<<max<<endl;
}
