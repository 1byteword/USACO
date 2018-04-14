import java.io.*;
import java.util.*;

public class snowboots {
	private static int[] tiles;
	private static int[] depth;
	private static int[] steps;
	private static int n;
	private static int b;
	private static int ans = 9999;
	private static boolean[][] vis;
	public static void bfs(int index, int boot) {
		if(vis[index][boot]) return;
		if(index==n-1) {
			ans = Math.min(ans, boot);
			return;
		}
		//System.out.println(index + " " + boot);
		vis[index][boot] = true;
		for(int i = index+1; i-index <= steps[boot] && i < n; i++)  //try moving more steps
		{
			if(tiles[i]<=depth[boot]) bfs(i, boot);
		}
		
		for(int i = boot+1; i < b; i++)  //try using the next boot on the same index
		{
			if(tiles[index]<=depth[i]) bfs(index, i);
		}
		return;
	}
	
	public static void main(String[] args)throws IOException
	{
		Scanner in = new Scanner(new File("snowboots.in"));
		PrintWriter out = new PrintWriter(new File("snowboots.out"));
		vis = new boolean[700][700];
		n = in.nextInt();
		b = in.nextInt();
		tiles = new int[n];
		for(int i = 0; i < n; i++)
		{
			tiles[i] = in.nextInt();
		}
				
		depth = new int[b];
		steps = new int[b];
		
		for(int i = 0; i < b; i++)
		{
			depth[i] = in.nextInt();
			steps[i] = in.nextInt();
		}
		
		bfs(0, 0);
		out.println(ans);
		out.close();
	}
	
}
 