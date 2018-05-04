/*
   ID: azklinu1
   PROG: ride
   LANG: C++
 */
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
	ifstream cin("ride.in");
	ofstream cout("ride.out");
	string a, b;	
	cin >> a >> b;
	int p1 = 1;
	int p2 = 1;
	for(int i = 0; i < a.length(); i++)
	{
		p1 *= (int)(a[i]+1)-65;
	}
	for(int e = 0; e < b.length(); e++)
	{
		p2 *= (int)(b[e]+1)-65;
	}
	p1%=47;
	p2%=47;
	if((p1) == (p2))
	{
		cout << "GO" << endl;
	}
	else{
		cout << "STAY" << endl;
	}
	return 0;
}
