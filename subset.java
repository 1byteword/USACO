/*
ID: azklinu1
LANG: JAVA
TASK: subset 
*/
import java.io.*;
import java.util.*;

public class subset {
	static long dp[][] = new long[9000][50];
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("subset.in"));
		PrintWriter out = new PrintWriter(new FileWriter("subset.out"));
		int n = kb.nextInt();
		int sum = n*(n+1)/2;
		for(int i = 0; i < dp.length; i++)
		{
			Arrays.fill(dp[i], -1);
		}
		if(sum%2!=0) out.println(0);
		else out.println(ways(sum/2, n)/2);
		out.close();
	}
	
	public static long ways(int n, int k)
	{
		if(n<0||k<0) return 0;
		if(dp[n][k]!=-1) return dp[n][k];
		if(n==0&&k==0) return dp[n][k] = 1;
		return dp[n][k] = ways(n, k-1) + ways(n-k, k-1);
	}
}
 