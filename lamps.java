/*
ID: azklinu1
LANG: JAVA
TASK: lamps 
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class lamps {
	static int c;
	static TreeSet<String> ans;
	static ArrayList<Integer> one;
	static ArrayList<Integer> two;
	private static boolean arr[];

	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		//long start = System.currentTimeMillis();
		Scanner kb = new Scanner(new File("lamps.in"));
		PrintWriter out = new PrintWriter(new FileWriter("lamps.out"));
		int n = Integer.parseInt(kb.nextLine());
		c = Integer.parseInt(kb.nextLine());
		one = new ArrayList<>(); // possible error
		two = new ArrayList<>();

		String o = kb.nextLine();
		String t = kb.nextLine();
		String[] t1 = o.split(" ");
		for (String s : t1) {
			if (!s.equals("-1"))
				one.add(Integer.parseInt(s) - 1);
		}
		// System.out.println(one);
		String[] t2 = t.split(" ");
		for (String s : t2) {
			if (!s.equals("-1"))
				two.add(Integer.parseInt(s) - 1);
		}
		// System.out.println(two);
		ans = new TreeSet<>();
		String orig = "";
		for(int i = 0; i < n; i++)
		{
			orig+="1";
		}
		StringBuilder sb = new StringBuilder(orig);
		for (int i = 0; i < orig.length(); i++) {
			if (orig.charAt(i) == '0')
				sb.setCharAt(i, '1');
		}
		String implem = sb.toString();
		arr = new boolean[4];
		bfs(implem, 0);
		if (ans.size() == 0)
			out.println("IMPOSSIBLE");
		else {
			for (String s : ans) {
				out.println(s);
			}
		}
		//System.out.println(System.currentTimeMillis()-start);
		out.close();
	}

	public static boolean isOk(String con) {
		for (int i : one) {
			if (con.charAt(i) == '0')
				return false;
		}
		for (int i : two) {
			if (con.charAt(i) == '1')
				return false;
		}
		return true;
	}

	public static void bfs(String con, int count) {
		if (count > c)
			return;
		if (isOk(con))
			ans.add(con);
		// button 1;
		// System.out.println(con);
		if (!arr[0]) {
			StringBuilder sb = new StringBuilder(con);
			for (int i = 0; i < con.length(); i++) {
				if (con.charAt(i) == '1')
					sb.setCharAt(i, '0');
				else
					sb.setCharAt(i, '1');
			}
			String res = sb.toString();
			arr[0] = true;
			bfs(res, count + 1);
			arr[0] = false;
		}
		// button 1

		// button 2
		if (!arr[1]) {
			StringBuilder but2 = new StringBuilder(con);
			for (int i = 0; i < con.length(); i += 2) {
				if (con.charAt(i) == '1')
					but2.setCharAt(i, '0');
				else
					but2.setCharAt(i, '1');
			}
			String b2 = but2.toString();
			arr[1] = true;
			bfs(b2, count + 1);
			arr[1] = false;
		}
		// button 2

		// button 3
		if (!arr[2]) {
			StringBuilder but3 = new StringBuilder(con);
			for (int i = 1; i < con.length(); i += 2) {
				if (con.charAt(i) == '1')
					but3.setCharAt(i, '0');
				else
					but3.setCharAt(i, '1');
			}
			String b3 = but3.toString();
			arr[2] = true;
			bfs(b3, count + 1);
			arr[2] = false;
		}
		// button 3

		// button 4
		if (!arr[3]) {
			StringBuilder but4 = new StringBuilder(con);
			for (int j = 0; j < con.length(); j += 3) {
				if (con.charAt(j) == '1')
					but4.setCharAt(j, '0');
				else
					but4.setCharAt(j, '1');
			}
			String b4 = but4.toString();
			arr[3] = true;
			bfs(b4, count + 1);
			arr[3] = false;
		}

		// button 4
		return;
	}

}
