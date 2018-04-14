import java.io.*;
import java.util.*;

public class lazy {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("lazy.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lazy.out"));
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[][] boo = new int[801][801];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				boo[i][j] = kb.nextInt();
			}
		}
		
		long[][] arr = new long[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = n-1; j >= 0; j--)
			{
				arr[i][n-1-j] = boo[j][i];
			}
		}
		long[][] mat = new long[801][801];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++) {
				mat[i][j] = arr[i][j];
				if(i>0&&j==0)mat[i][j]+=mat[i-1][n-1];
				else if(j > 0) mat[i][j]+=mat[i][j-1];
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		long max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				try {
					long query = mat[i+k][j+k]-mat[i+k][j-k]-mat[i-k][j+k]+mat[i-k][j-k];
					max = Math.max(max, query);
				}catch(ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		System.out.println(max);
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
	//public class lazy {

}
 