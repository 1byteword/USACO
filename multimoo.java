import java.io.*;
import java.util.*;

public class multimoo {
	private static int[][] arr;
	private static boolean[][] vis;
	private static int n;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static boolean inb(int x, int y)
	{
		return x>=0&&y>=0&&x<n&&y<n;
	}
	
	public static int bfs(int x, int y, int dist)
	{
		vis[x][y] = true;
		//dist++;
		//System.out.println("approaching x " + x + " and y " + y + " with current dist of " + dist);
		for(int i = 0; i < 4; i++) {
			int sx = x+dx[i];
			int sy = y+dy[i];
			if(inb(sx, sy) && arr[sx][sy] == arr[x][y] && !vis[sx][sy])
			{
				dist=Math.max(dist, bfs(sx,sy,dist+1));
			}
		}
		//vis[x][y] = false;
		return dist;
	}
	
	public static int bfs2(int x, int y, int dist, int numregions, int firstid, int secondid)
	{
		vis[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(inb(sx, sy) && !vis[sx][sy])
			{
				if(secondid==-1)
				{
					secondid = arr[sx][sy];
					vis[sx][sy] = true;
					dist = Math.max(dist, bfs2(sx, sy, dist+1, numregions+1, firstid, arr[sx][sy]));
					//vis[sx][sy] = false;
					//secondid = -1;
				}
				else if(arr[sx][sy] == firstid || arr[sx][sy] == secondid)
				{
					vis[sx][sy] = true;
					dist=Math.max(dist, bfs2(sx, sy, dist+1, numregions, firstid, secondid));
					//vis[sx][sy] = false;
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("multimoo.in"));
		PrintWriter out = new PrintWriter(new FileWriter("multimoo.out"));
		n = kb.nextInt();
		
		arr = new int[n][n];
		vis = new boolean[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				arr[i][j] = kb.nextInt();
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(!vis[i][j])
				{
					int groupsize = bfs(i, j, 1);
					max = Math.max(max, groupsize);
				}
			}
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				vis[i][j] = false;
			}
		}
		int groupmax = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				int groupsize = bfs2(i, j, 1, 1, arr[i][j], -1);               //x, y, current steps travelled, different components visited
				vis = new boolean[n][n];
				groupmax = Math.max(groupsize, groupmax);
				vis = new boolean[n][n];
			}
		}
		out.println(max);
		out.println(groupmax);
		out.close();
	}
}