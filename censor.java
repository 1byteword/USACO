
import java.io.*;
import java.util.*;

public class censor {
	// d is the number of characters in input alphabet
	public final static int d = 256;

	/*
	 * pat -> pattern txt -> text q -> A prime number
	 */
	static String search(String pat, String txt, int q) {
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for txt
		int h = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i < N - M; i++) {

			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (p == t) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == M) {
					txt=txt.substring(0,i)+txt.substring(i+M);
					//if(i>=M)i-=M;
					//else i = 0;
				}
			}

			// Calculate hash value for next window of text: Remove
			// leading digit, add trailing digit
			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

				// We might get negative value of t, converting it
				// to positive
				if (t < 0)
					t = (t + q);
			}
		}
		return txt;
	}

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("censor.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("censor.out"));
		String s = kb.next();
		String rem = kb.next();
		s = search(rem, s, 1000000007);
		System.out.println(s);
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
	// public class censor {

}
