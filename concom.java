/*
ID: azklinu1
LANG: JAVA
TASK: concom 
*/
import java.io.*;
import java.util.*;

public class concom {
	private static HashMap<Integer, HashSet<Pair>> map;

	public static void main(String[] args) throws IOException {
		//.in);
		Scanner kb = new Scanner(new File("concom.in"));
		
		PrintWriter out = new PrintWriter(new FileWriter("concom.out"));
		int n = kb.nextInt();
		int[][] adj = new int[105][105];
		for(int i = 0; i < n; i++)
		{
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			adj[a][b] = c;
		}
		boolean[][] vis = new boolean[105][105];
		for(int i = 1; i <= 100; i++)
		{
			for(int j = 1; j <= 100; j++)
			{
				if(i!=j && !vis[i][j] && adj[i][j] > 50)
				{
					//System.out.println("entered if");
					vis[i][j] = true;
					for(int k = 1; k <= 100; k++)
					{
						adj[i][k] += adj[j][k];
						if(vis[j][k]) vis[i][k] = true;
					}
					j=0;
				}
			}
		}
		
		for(int i = 0; i <= 100; i++)
		{
			for(int j = 0; j <= 100; j++)
			{
				if(vis[i][j] && i!=j) out.println(i + " " + j);
			}
		}
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
	// public class G {

}
