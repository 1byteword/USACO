
/*
ID: azklinu1
LANG: JAVA
TASK: runround 
 */
import java.io.*;
import java.util.*;

public class runround {
	public static void main(String[] args) throws IOException {
		// Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("runround.in"));
		PrintWriter out = new PrintWriter(new FileWriter("runround.out"));
		int n = kb.nextInt();
		boolean found = false;
		for (int i = n + 1; !found; i++) {
			int[] nums = new int[10];
			int temp = i;
			while(temp > 0)
			{
				int lsb = temp%10;
				nums[lsb]++;
				temp/=10;
			}
			if(nums[0]>0) continue;
			boolean stillin = true;
			for(int j = 1; j < 10; j++)
			{
				if(nums[j] > 1) stillin = false;
			}
			char[] arr = Integer.toString(i).toCharArray();
			int index = 0;
			int count = 0;
			int[] vis = new int[arr.length];
			while (count < arr.length && stillin) {
				if (index == (index + Integer.parseInt(arr[index] + "")) % arr.length) {
					//System.out.println("index " + index);
					//System.out.println("new index " + Integer.parseInt(arr[index] + "") % arr.length);
					stillin = false;
					continue;
				}
				vis[index]++;
				count++;
				index = ((index + Integer.parseInt(arr[index] + "")) % arr.length);
			}
			// System.out.println(i);
			boolean ans = true;
			colon: {
				for (int j = 0; j < vis.length; j++) {
					if (vis[j] != 1) {
						ans = false;
						//System.out.println(i);
						break colon;
					}
				}
			}
			if(index != 0) ans = false;
			if (ans) {
				//System.out.println(Arrays.toString(vis));
				out.println(i);
				found = true;
			}
			//out.println(Arrays.toString(vis));
		}
		out.close();
	}
}
