import java.io.*;
import java.util.*;

public class msched {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("msched.in"));
		PrintWriter out = new PrintWriter(new FileWriter("msched.out"));
		int n = kb.nextInt();
		Pair[] arr = new Pair[n];
		int[] max = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = new Pair(kb.nextInt(), kb.nextInt());
			max[i] = Math.max(max[i], arr[i].x);
		}
		
		int ans = 0;
		int curcow = 0;
		for(int t = 0; t < n; t++) {
			ans+=max[t];
		}

		System.out.println(ans);
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
			if(p.y != this.y) return p.y-this.y;
			else if(p.x != this.x) return this.x-p.x;
			return 0;
		}

		public String toString() {
			return x + " " + y;
		}
	}
	//public class msched {

}
 