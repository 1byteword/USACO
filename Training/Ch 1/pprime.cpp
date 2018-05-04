/**
   ID: azklinu1
   TASK: pprime
   LANG: C++
**/
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string.h>
#include <math.h>
#include <functional>
#include <cstdlib>
using namespace std;

#define pb push_back

bool isp(int n)
{
	if(n%2 == 0 || n < 1) return false;
	int m = sqrt(n*1.0);
	for(int i = 3; i <= m; i+=2)
	{
		if(n%i == 0) return false;
	}
	return true;
}

int main()
{
	ifstream cin("pprime.in");
	ofstream cout("pprime.out");
	int a, b;
	cin >> a >> b;

	//single digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		if(i >= a && i <= b && isp(i)) cout << i << endl;
	}
	//two digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		int tbp = i * 10 + i;
		if(isp(tbp) && tbp >= a && tbp <= b) cout << tbp << endl;	
	}
	//three digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		for(int j = 0; j <= 9; j++)
		{
			int to_be_pushed = i*100+j*10+i;
			if(isp(to_be_pushed) && to_be_pushed >= a && to_be_pushed <= b) cout << to_be_pushed << endl;
		}
	}
	//four digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		for(int j = 1; j <= 9; j++)
		{
			int tbp = i * 1000 + j * 100 + j * 10 + i;
			if(tbp >= a && tbp <= b && isp(tbp)) cout << tbp << endl;
		}
	}
	//five digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		for(int j = 0; j <= 9; j++)
		{
			for(int k = 0; k <= 9; k++)
			{
				int tbp = i*10000+j*1000+k*100+j*10+i;
			       	if(tbp >= a && tbp <= b && isp(tbp)) cout << tbp << endl;	
			}
		}
	}
	//six digit palindromes
	for(int i = 1; i <= 9; i+=2)
	{
		for(int j = 1; j <= 9; j++)
		{
			for(int k = 1; k <= 9; k++)
			{
				int tbp = i*100000 + j*10000 + k*1000 + k*100 + j*10 + i;
				if(tbp >= a && tbp <= b && isp(tbp)) cout << tbp << endl;
			}
		}
	}
	//seven digit palindromes	
	//cout << "a " << a << endl;
	//cout << "b " << b << endl;
	for(int j = 1; j <= 9; j+=2){
		for(int k = 0; k <= 9; k++){
			for(int c = 0; c <= 9; c++){
				for(int d = 0; d<=9; d++){
				int tbp = (j*1000000) + (k*100000) + (c*10000) + (d*1000) + (c*100) + (k*10) + j;
					if(tbp >= a)
					       if(tbp <= b){
						       //cout << "yes" << endl;
					       		if(isp(tbp)){	       
								//cout << "yeet" << endl;
								cout << tbp << endl;
							}
					       }
					}
				}
			}
		}
	//eight digit palindromes
	for(int a = 1; a <= 9; a+=2)
	{
		for(int b = 0; b <= 9; b++)
		{
			for(int c = 0; c <= 9; c++)
			{
				for(int d = 0; d <= 9; d++)
				{
					int tbp = (a*10000000) + (b*1000000) + (c*100000) + (d*10000) + (d*1000) + (c*100) + (b*10) + a;
					if(isp(tbp) && tbp >= a && tbp <= b) cout << tbp << endl;
				}
			}
		}
	}
}
