
/*
ID: azklinu1
LANG: JAVA
TASK: prefix
*/
import java.io.*;
import java.util.*;

public class prefix {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("prefix.in"));
		// Scanner kb = new Scanner(new File("______.__"));
		PrintWriter out = new PrintWriter(new FileWriter("prefix.out"));
		// int n = kb.nextInt();
		String line = "";
		ArrayList<String> list = new ArrayList<String>();
		while (kb.hasNext()) {
			String s = kb.next();
			if (s.equals("."))
				break;
			list.add(s);
		}
		// String[] arr = line.split(" ");
		kb.nextLine();
		StringBuilder sb = new StringBuilder();
		while (kb.hasNextLine()) {
			sb.append(kb.nextLine());
		}
		String word = sb.toString();
		int[] dp = new int[word.length() + 5];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		//System.out.println(list);
		//System.out.println(word);
		int ans = 0;
		for (int i = 1; i <= word.length(); i++) {
			for (String k : list) {
				// if(k.length()==0) continue;
				if (k.length() <= i) {
					//System.out.println("enter 1");
					if (dp[i - k.length()] != -1) {
						//System.out.println("enter 2");
						if (word.substring(i - k.length(), i).equals(k)) {
							//System.out.println("enter 3");
							dp[i] = Math.max(dp[i], k.length()+dp[i-k.length()]);
							ans = i;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, dp[i]);
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
	// public class prefix {

}
