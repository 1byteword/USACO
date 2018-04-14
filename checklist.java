import java.io.*;
import java.util.*;

public class checklist {
	public static int dist(Pair a, Pair b) {
		return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
	}
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("checklist.in"));
		PrintWriter out = new PrintWriter(new FileWriter("checklist.out"));
		int n = kb.nextInt();
		int k = kb.nextInt();
		Pair[] holsteins = new Pair[n];
		Pair[] gournseys = new Pair[k];
		for(int i = 0; i < n; i++)
		{
			holsteins[i] = new Pair(kb.nextInt(), kb.nextInt());
		}
		
		for(int i = 0; i < k; i++)
		{
			gournseys[i] = new Pair(kb.nextInt(), kb.nextInt());
		}
		
		int[][][] dp = new int[n+1][k+1][2];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < k; j++)
			{
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		dp[1][0][0] = 0;
		for(int i = 0; i < dp.length; i++)
		{
			for(int j = 0; j < dp[i].length; j++)
			{
				for(int current = 0; current < 2; current++)
				{
					if((i==0&&current==0)||(j==0&&current==1)) {
						continue;
					}
					Pair src = null;
					if(current == 0) src = holsteins[i-1];
					else src = gournseys[j-1];
					if(i<n) dp[i+1][j][0] = Math.min(dp[i+1][j][0], dp[i][j][current]+dist(src, holsteins[i])); 
					if(j<k) dp[i][j+1][1] = Math.min(dp[i][j+1][1], dp[i][j][current]+dist(src, gournseys[j]));
				}
			}
		}
		System.out.println(dp[n][k][0]);
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
	//public class checklist {

}
 