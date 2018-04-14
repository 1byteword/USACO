import java.io.*;
import java.util.*;

public class helpcross {
	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("helpcross.in"));
		PrintWriter out = new PrintWriter(new FileWriter("helpcross.out"));
		int n = kb.nextInt();
		int m = kb.nextInt();

		Pair[] arr = new Pair[m];
		int[] chick = new int[n];
		for (int i = 0; i < n; i++) {
			chick[i] = kb.nextInt();
		}
		for(int i = 0; i < m; i++)
		{
			arr[i] = new Pair(kb.nextInt(), kb.nextInt());
		}
		Arrays.sort(arr);
		Arrays.sort(chick);
		int chicknum = 0;
		int ans = 0;
		for(Pair a : arr)
		{
			if(chick[chicknum] > a.x && chick[chicknum] < a.y) {
				chicknum++;
				ans++;
			}
		}
		out.println(m-ans);
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
			if (y < p.y)
				return p.y - y;
			else if (y > p.y)
				return y - p.y;
			else if (x < p.x)
				return p.x - x;
			else if (x > p.x)
				return x - p.x;
			return 0;
		}

		public String toString() {
			return x + " " + y;
		}
	}
	// public class helpcross {

}
