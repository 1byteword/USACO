
import java.io.*;
import java.util.*;

public class homework {
	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("homework.in"));
		PrintWriter out = new PrintWriter(new FileWriter("homework.out"));
		int n = kb.nextInt();
		long[] arr = new long[n];
		long[] pref = new long[n];
		long[] qmin = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			pref[i] = arr[i];
		}
		for (int i = 1; i < n; i++) {
			pref[i] += pref[i - 1];
		}
		qmin[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			qmin[i] = Math.min(arr[i], qmin[i + 1]);
		}
		// System.out.println(Arrays.toString(pref));
		// System.out.println(Arrays.toString(qmin));
		long max = -1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < n - 1; i++) {
			long query = pref[n - 1] - pref[i - 1];
			long minq = qmin[i];
			// System.out.println("reached i = " + i);
			long sum = (query - minq) / (n - 1 - i);

			// System.out.println("for k = " + i + " the query is " + sum);
			// System.out.println("for k = " + i + " the min element is " + minq);
			if (sum == max) {
				list.add(i);
			} else if (sum > max) {
				max = sum;
				list.clear();
				list.add(i);
			}
		}
		// System.out.println(max);
		String ans = "";
		for (long i : list) {
			ans += i + " ";
		}
		out.print(ans.substring(0, ans.length() - 1));
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
	// public class homework {

}
