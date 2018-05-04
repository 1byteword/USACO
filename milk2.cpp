/*
ID: azklinu1
PROG: milk2
LANG: C++11
*/

#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
using namespace __gnu_pbds;
 
typedef long long ll;

vector<int> vi;
typedef pair<int, int> pii;
typedef tree<int,null_type,less<int>,rb_tree_tag,tree_order_statistics_node_update> ordered_set;
typedef vector<pii> ii;
#define FOR(i, a, b) for (int i=a; i<b; i++)
#define F0R(i, a) for (int i=0; i<a; i++)
#define FORd(i,a,b) for (int i = (b)-1; i >= a; i--)
#define F0Rd(i,a) for (int i = (a)-1; i >= 0; i--)
 
#define mp make_pair
#define pb push_back
#define f first
#define s second
#define lb lower_bound
#define ub upper_bound


int main() {
  
  ifstream cin("milk2.in");
  ofstream cout("milk2.out");

  int N; cin >> N;
  ii v;
  FOR(i, N) {
    int a, b; cin >> a >> b;
    v.pb(mp(a, b));
  }

  sort(v.begin(), v.end());

  cout << v[0];
}
