import java.io.*;
import java.util.*;

public class outofplace {
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		//Scanner kb = new Scanner(new File("______.__"));
		//PrintWriter out = new PrintWriter(new FileWriter("______.__"));
		//int n = kb.nextInt();
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
	//public class outofplace {

}
 