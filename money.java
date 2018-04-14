import java.io.*;
import java.util.*;
/*
ID: azklinu1
LANG: JAVA
TASK: money 
*/
public class money {

	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("money.in"));
		PrintWriter out = new PrintWriter(new FileWriter("money.out"));
		int n = kb.nextInt();
		int v = kb.nextInt();
		int[] coins = new int[35];
		for (int i = 1; i <= n; i++) {
			coins[i] = kb.nextInt();
		}
		long[][] dp = new long[30][10005];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= v; j++) {
				if (j == 0)
					dp[i][j] = 1;
				else if (j - coins[i] < 0)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
			}
		}
		out.println(dp[n][v]);
		out.close();
	}
}
