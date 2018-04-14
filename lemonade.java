
import java.io.*;
import java.util.*;

public class lemonade {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("lemonade.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lemonade.out"));
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}
		Arrays.sort(arr);
		int currsize = 0;
		for(int i = n-1; i >= 0; i--) {
			if(currsize==0) {
				currsize++;
				continue;
			}
			else {
				if(currsize<=arr[i])currsize++;
			}
		}
		out.println(currsize);
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
	//public class lemonade {

}
 