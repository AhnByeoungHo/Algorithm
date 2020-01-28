package bak20200128;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long k = a*b*c;
		int[] count = new int[10];
		while(k!=0) {
			int temp = (int) (k%10);
			count[temp]++;
			k /= 10;
		}
		for(int i=0;i<10;i++)
			System.out.println(count[i]);
	}

}
