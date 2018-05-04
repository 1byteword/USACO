/** 
     ID: azklinu1
     LANG: C++11
     PROG: sprime
**/
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <bitset>
#include <cmath>

#define pb push_back
#define mp make_pair

using namespace std;

int N;
vector<int> rib;
int s, e;

bool prime(int N)
{
	if(N%2 == 0 || N == 1) return false;

	for(int i = 3; i <= ceil(sqrt(N)); i++)
	{
		if(N%i == 0) return false;
	}
	return true;
}

void genSin()
{
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	rib.pb(2);
	rib.pb(3);
	rib.pb(5);
	rib.pb(7);

	s = 0;
	e = rib.size();
	if(N==1){
		for(int a : rib) cout << a << endl;
	}
}

void genDoub(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 2){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genTri(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 3){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genQuad(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 4){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genPen(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 5){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genHex(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 6){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genSep(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 7){
					if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

void genOct(){
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	for(int i = s; i < e; i++)
	{
		for(int j = 1; j <= 9; j+=2)
		{
			int check = rib[i]*10+j;
			if(prime(check)){
				if(N == 8){
				if(check >= pow(10, N-1) && check <= pow(10, N))
					{
						cout << check << endl;
						continue;
					}
				}
				else rib.pb(check);
			}
		}
	}
	s = e;
	e = rib.size();
}

int main()
{
	ifstream cin("sprime.in");
	ofstream cout("sprime.out");
	cin >> N;
	if(N == 1){ 
		genSin();
	}

	if(N == 2){
		genSin();
		genDoub();
	}
	if(N == 3){
		genSin();
		genDoub();
		genTri();
	}
	if(N == 4){
		genSin();
		genDoub();
		genTri();
		genQuad();
	}

	if(N == 5){
		genSin();
		genDoub();
		genTri();
		genQuad();
		genPen();
	}
	if(N == 6){
		genSin();
		genDoub();
		genTri();
		genQuad();
		genPen();
	     	genHex();
	}
	if(N == 7){
		genSin();
		genDoub();
		genTri();
		genQuad();
		genPen();
		genHex();
		genSep();
	}
	if(N == 8){
		genSin();
		genDoub();
		genTri();
		genQuad();
		genPen();
		genHex();
		genSep(); 
		genOct();
	}
	
	//sort(v.begin(), v.end());

	/**for(int i : rib)
	{
		//if(rib[i] >= pow(10, N-1) && rib[i] <= pow(10, N)) 
		cout << rib[i] << endl;	
	}**/
}
