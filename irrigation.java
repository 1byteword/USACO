import java.io.*;
import java.util.*;

public class irrigation {
	static int n;

	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		FastScanner kb = new FastScanner("irrigation.in");
		PrintWriter out = new PrintWriter(new FileWriter("irrigation.out"));
		n = kb.nextInt();
		int k = kb.nextInt();
		Pair[] arr = new Pair[n];
		par = new int[5005];
		HashMap<Integer, Pair> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(kb.nextInt(), kb.nextInt());
			par[i] = i;
			map.put(map.size(), arr[i]);
		}
		
		PriorityQueue<pointdist> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++)
		{
			Pair a = map.get(i);
			for(int j = 0; j < n; j++) {
				if(i==j) continue;
				Pair b = map.get(j);
				Pair c = new Pair(i, j);
				
				pq.add(new pointdist(c, a.euclidDist(b)));
			}
		}
		int ans = 0;
		
		while(!pq.isEmpty() && n>0) {
			pointdist top = pq.poll();
			Pair c = top.p;
			Pair a = map.get(c.x);
			Pair b = map.get(c.y);
			//System.out.println("pair a " + a);
			//System.out.println("pair b " + b);
			if(find(c.x) != find(c.y) && a.euclidDist(b) >= k)
			{
				unite(c.x, c.y);
				ans+=a.euclidDist(b);
				//System.out.println(ans);
			}
		}
		
		out.println(ans);
		out.close();
	}
	public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

	static int par[];

	static int find(int x) {
		if (par[par[x]] == par[x])
			return par[x];
		else
			return par[x] = find(par[x]);
	}

	static void unite(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
			// swap(a, b);
		}
		par[b] = a;
		n--;
	}
	static class pointdist implements Comparable<pointdist>{
		private Pair p;
		private int dist;
		
		public pointdist(Pair a, int d)
		{
			p = a;
			dist = d;
		}
		
		public int compareTo(pointdist other)
		{
			if(other.dist != this.dist)
			{
				return this.dist-other.dist;
			}
			else if(this.p.x!=other.p.x) {
				return this.p.x-other.p.x;
			}
			else return this.p.y-other.p.y;
		}
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

		public int euclidDist(Pair a) {
			return (a.x - this.x) * (a.x - this.x) + (a.y - this.y) * (a.y - this.y);
		}

		public String toString() {
			return x + " " + y;
		}
	}
}
