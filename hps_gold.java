import java.io.*;
import java.util.*;

public class hps_gold {
	
	public static int optimal(char a)
	{
		if(a == 'H')
			return 2;
		if(a == 'P')
			return 3;
		else
			return 1;
	}
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("hps.in"));
		PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
		int n = Integer.parseInt(kb.next());
		int k = Integer.parseInt(kb.next());
		char[] arr = new char[n];
		
		for(int i = 0; i < n ; i++)
		{
			arr[i] = kb.next().charAt(0);
		}
		
		int[][][] dp = new int[n][k][3];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < k; j++)
			{
				
			}
		}
		
		
	}
}
 