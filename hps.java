//AC
import java.io.*;
import java.util.*;

public class hps {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("hps.in"));
		PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
		int n = Integer.parseInt(kb.nextLine());
		char[] arr = new char[n];
		boolean[] isH = new boolean[n];
		boolean[] isP = new boolean[n];
		boolean[] isS = new boolean[n];
		
		for(int i = 0; i < n; i++)
		{
			arr[i] = kb.nextLine().charAt(0);
			if(arr[i]=='H')isH[i] = true;
			if(arr[i]=='P')isP[i] = true;
			if(arr[i]=='S')isS[i] = true;
		}
		
		int[] cH = new int[n];
		int[] cP = new int[n];
		int[] cS = new int[n];
		
		if(isH[0])cH[0]++;
		if(isP[0])cP[0]++;
		if(isS[0])cS[0]++;
		
		for(int i = 1; i < n; i++)
		{
			cH[i] = cH[i-1];
			cP[i] = cP[i-1];
			cS[i] = cS[i-1];
			if(isH[i]) cH[i]++;
			if(isP[i]) cP[i]++;
			if(isS[i]) cS[i]++;
		}
		
		int max = Integer.MIN_VALUE;
		max = Integer.max(Integer.max(cH[n-1], cP[n-1]), cS[n-1]);
		
		int countH = 0;
		int countP = 0;
		int countS = 0;
		if(isH[0])countH++;
		if(isP[0])countP++;
		if(isS[0])countS++;
		
		for(int i = 1; i < n; i++)
		{
			if(isH[i])countH++;
			max = Integer.max(Integer.max(max, countH), Integer.max(countH+(cP[n-1]-cP[i]), countH+(cS[n-1]-cS[i])));
		}
		
		for(int i = 1; i < n; i++)
		{
			if(isP[i])countP++;
			max = Integer.max(Integer.max(max, countP), Integer.max(countP+(cH[n-1]-cH[i]), countP+(cS[n-1]-cS[i])));
		}
		
		for(int i = 1; i < n; i++)
		{
			if(isS[i])countS++;
			max = Integer.max(Integer.max(max, countS), Integer.max(countS+(cH[n-1]-cH[i]), countS+(cP[n-1]-cP[i])));
		}
		
		out.println(max);
		out.close();
	}
}
 