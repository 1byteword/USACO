/*
ID: azklinu1
LANG: JAVA
TASK: nocows 
*/
import java.io.*;
import java.util.*;

public class nocows {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("nocows.in"));
		PrintWriter out = new PrintWriter(new FileWriter("nocows.out"));
		int n = kb.nextInt();
		int k = kb.nextInt();
		long[][] dp = new long[500][500];
		int mod = 9901;
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= k; j++)
			{
				if(i==1) dp[i][j] = 1;
				else {
					for(int l = 1; l <= i-2; l++)
					{
						dp[i][j] += dp[l][j-1]*dp[i-l-1][j-1];
						dp[i][j] %= mod; 
					}
				}
			}
		}
		
		out.println((dp[n][k]-dp[n][k-1]+mod)%mod);
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		private int x;
		private int y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}

		public int getFirst() {
			return x;
		}

		public int getSecond() {
			return y;
		}

		public int compareTo(Pair p) {
			if (x < p.x)
				return p.x - x;
			else if (x > p.x)
				return x - p.x;
			else if (y < p.y)
				return p.y - y;
			else if (y > p.y)
				return y - p.y;
			return 0;
		}

		public String toString() {
			return x + " " + y;
		}
	}
	//public class pedigree {

}
 