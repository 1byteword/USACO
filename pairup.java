import java.io.*;
import java.util.*;

public class pairup {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("pairup.in"));
		PrintWriter out = new PrintWriter(new FileWriter("pairup.out"));
		int n = kb.nextInt();
		Pair[] arr = new Pair[n];
		for(int i = 0; i < n; i++)
		{
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			arr[i] = new Pair(a, b);
		}
		Arrays.sort(arr);
		int i = 0; int j = n-1;
		int m = 0;
		//System.out.println(Arrays.toString(arr));
		while(i!=j)
		{
			int x = (int) Math.min(arr[i].x, arr[j].x);
			//System.out.println(x);
			if(i==j) x/=2;
			m = Math.max(m, arr[i].y+arr[j].y);
			arr[i].x-=x;
			arr[j].x-=x;
			if(arr[i].x==0) i++;
			if(arr[j].x==0) j--;
		}
		out.println(m);
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
			return (int)(this.y - p.y);
		}

		public String toString() {
			return x + " " + y;
		}
	}
	//public class pairup {

}
 