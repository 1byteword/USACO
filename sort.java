import java.io.*;
import java.util.*;

public class sort {
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) throws IOException {
		//Scanner kb = new Scanner(System.in);
		Scanner kb = new Scanner(new File("sort.in"));
		PrintWriter out = new PrintWriter(new FileWriter("sort.out"));
		int n = kb.nextInt();
		int[] list = new int[n];
		int[] sorted = new int[n];
		for(int i = 0; i < n; i++)
		{
			list[i] = kb.nextInt();
			sorted[i] = list[i];
		}
		Arrays.sort(sorted);
		int ans = 0;
		//System.out.println(list);
		
		for(int i = 0; i < n; i++)
		{

			int index = -1;
			//System.out.println(Arrays.binarySearch(sorted, list[i]));
			int lo = 0;
			int hi = n-1;
			while(true)
			{
				int mid = (lo+hi)/2;
				//System.out.println("lo " + lo + " hi " + hi);
				if(sorted[mid]==list[i]) {
					
					index = mid;
					//System.out.println("index " + index);
					break;
				}
				else if(sorted[mid] > list[i]) hi = mid-1;
				else lo = mid+1;
			}
			//index = lo;
			//System.out.println("before array " + Arrays.toString(list));
			swap(list, i, index);
			//System.out.println("after array " + Arrays.toString(list));
			ans++;
		}
		out.println(ans-1);
		out.close();
	}
}
 