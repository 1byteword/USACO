/*
ID: azklinu1
LANG: JAVA
TASK: friday
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class friday {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("friday.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(new File("friday.out")));
		//String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday","Friday", "Saturday", "Sunday"};
		int[] t = new int[7]; //how many times 13 falls on a day
		int n = sc.nextInt();
		//int day = 0;
		int c = 0;
		int[] normDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int i = 1900; i < (1900+n); i++)
		{
			for(int j = 0; j < 12; j++)
			{
				int day = ((c+12) % 7);
				t[day]++;
				if(isL(i))
				{
					c+=leapDays[j];
				}
				else
				{
					c+=normDays[j];
				}
			}
		}
		
		pw.print(t[5]);
		pw.print(' ');
		pw.print(t[6]);
		pw.print(' ');
		pw.print(t[0]);
		pw.print(' ');
		pw.print(t[1]);
		pw.print(' ');
		pw.print(t[2]);
		pw.print(' ');
		pw.print(t[3]);
		pw.print(' ');
		pw.print(t[4] + "\n");
		pw.close();
	}
	
	public static boolean isL(int y)
	{ 
		if(y % 4 == 0 && y % 100 != 0)
		{
			return true;
		}
		if(y % 4 == 0 && y % 100 == 0 && y % 400 == 0)
		{
			return true;
		}
		return false;
	}
}
