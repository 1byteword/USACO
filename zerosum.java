/*
ID: azklinu1
LANG: JAVA
TASK: zerosum 
*/
import java.io.*;
import java.util.*;

public class zerosum {
	public static ArrayList<String> list;
	public static int n;

	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("zerosum.in"));
		PrintWriter out = new PrintWriter(new FileWriter("zerosum.out"));
		n = kb.nextInt();
		list = new ArrayList<String>();
		dfs(0, "1");
		//System.out.println(list);
		int[] nums = new int[n];
		for(int i = 0; i < n; i++)
		{
			nums[i] = i+1;
		}
		TreeSet<String> ans = new TreeSet<>();
		for(String c : list)
		{
			String s = c.replaceAll(" ", "");           //possible problem pls
			//System.out.println(s);
			//int sum = Integer.parseInt(c.split("[+-]")[0]);
			Queue<Integer> numbers = new LinkedList<>();
			Queue<Character> ops = new LinkedList<>();
			String currnum = "";
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='+'||s.charAt(i)=='-') {
					numbers.add(Integer.parseInt(currnum));
					ops.add(s.charAt(i));
					currnum = "";
				}
				else currnum+=s.charAt(i);
			}
			int lastind = Math.max(s.lastIndexOf("+"), s.lastIndexOf("-"));
			numbers.add(Integer.parseInt(s.substring(lastind+1)));
			//System.out.println(numbers);
			int sum = numbers.poll();
			while(ops.size()>0)
			{
				int b = numbers.poll();
				char o = ops.poll();
				if(o=='+')sum+=(+b);
				else sum+=(-b);
			}
			if(sum == 0) ans.add(c);
		}
		for(String a : ans)
		{
			out.println(a);
		}
		out.close();
	}

	public static void dfs(int k, String curr) {
		if (k == n - 1) {
			//curr = curr.replaceAll(" ", "");
			list.add(curr);
			return;
		}
		dfs(k+1, curr+"+"+(k+2));
		dfs(k+1, curr+"-"+(k+2));
		dfs(k+1, curr+" "+(k+2));
		return;
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
	// public class zerosum {

}
