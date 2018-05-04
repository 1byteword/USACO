/**
   ID: azklinu1
   LANG: C++
   TASK: numtri
**/
#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

int arr[1001][1001];
int dp[1001][1001];
int main()
{
  ifstream cin ("numtri.in");
  ofstream cout ("numtri.out");

  int N; cin >> N;
  for(int i = 1; i <= N; i++)
    {
      for(int j = 1; j <= i; j++)
	{
	  cin >> arr[i][j];
	}
    }
  
  dp[1][1] = arr[1][1];
  for(int i = 2; i <= N; i++)
    {
      for(int j = 1; j <= i; j++)
	{
	  if(j == 1)
	    {
	      dp[i][j] = dp[i-1][j] + arr[i][j];
	    }
	  else if(j == i)
	    {
	      dp[i][j] = dp[i-1][j-1] + arr[i][j];
	    }
	  else
	    {
	      dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]);
	      dp[i][j] += arr[i][j];
	    }
	  //cout << dp[i][j] << " ";
	}
      //cout << endl;
    }
  //end
  
  int ans = -1;
  for(int i = 1; i <= N; i++)
    {
      ans = max(ans, dp[N][i]);
    }

  cout << ans << endl;
}
