import java.io.*;
import java.util.*;

public class reststops {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("reststops.in"));
		PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
		int l = kb.nextInt();
		int n = kb.nextInt();
		int rf = kb.nextInt();
		int rb = kb.nextInt();
		int[] x = new int[n];
		int[] c = new int[n];
		for(int i = 0; i < n; i++)
		{
			x[i] = kb.nextInt();
			c[i] = kb.nextInt();
		}
		int max = 0;
		boolean[] ismax = new boolean[n];
		for(int i = n-1; i >= 0; i--)
		{
			if(c[i] > max)
			{
				ismax[i] = true;
				max = c[i];
			}
		}
		long ans = 0;
		long tf = 0;
		long tb = 0;
		int lx = 0;
		for(int i = 0; i < n; i++)
		{
			if(ismax[i])
			{
				tf += (x[i]-lx)*((long)rf);
				tb += (x[i]-lx)*((long)rb);
				ans+=(tf-tb)*((long)c[i]);
				tb = 0;
				tf = 0;
				lx = x[i];
			}
		}
		out.println(ans);
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
	//public class reststops {

}
 