#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <climits>
#include <string.h>
using namespace std;

int N, Q;
int arr[50001], segmax[200001], segmin[200001];
int querymin(int node, int l, int r, int a, int b)
{
	if(l > r) return 0;
	if(l >= a && r <= b)
	{
		return segmin[node];
	}
	int mid = (l+r)/2;
	int q = 1000001;
	if(a <= mid)
	{
		int check = querymin(node*2, l, mid, a, b);
		q = min(q, check);
	}
	if(b>=mid+1)
	{
		int check = querymin(node*2+1, mid+1, r, a, b);
		q = min(q, check);
	}
	return q;
}

int querymax(int node, int l, int r, int a, int b)
{
	if(l > r) return 0;
	if(l >= a && r <= b)
	{
		return segmax[node];
	}
	int mid = (l+r)/2;
	int q = 0;
	if(a <= mid)
	{
		int check = querymax(node*2, l, mid, a, b);
		q = max(q, check);
	}
	if(b >= mid+1)
	{
		int check = querymax(node*2+1, mid+1, r, a, b);
		q = max(q, check);
	}
	return q;
}

void buildmax(int node, int l, int r)
{
	if(l > r) return;
	if(l == r)
	{
		segmax[node] = arr[l];
		return;
	}
	int mid = (l+r)/2;
	buildmax(2*node, l, mid);
	buildmax(2*node+1, mid+1, r);
	segmax[node] = max(segmax[2*node], segmax[2*node+1]);
}
void buildmin(int node, int l, int r)
{
	if(l > r) return;
	if(l == r)
	{
		segmin[node] = arr[l];
		return;
	}
	int mid = (l+r)/2;
	buildmin(2*node, l, mid);
	buildmin(2*node+1, mid+1, r);
	segmin[node] = min(segmin[2*node], segmin[2*node+1]);
}

int main()
{
	cin >> N >> Q;
	for(int i = 1; i <= N; i++)
	{
		cin >> arr[i];
	}
	buildmin(1, 1, N);
	buildmax(1, 1, N);
	for(int i = 0; i < Q; i++)
	{
		int a, b; cin >> a >> b;
		int mi = querymin(1, 1, N, a, b);
		int ma = querymax(1, 1, N, a, b);
		cout << abs(mi-ma) << endl;
	}
}
