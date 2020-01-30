package bak20200130;

import java.util.Scanner;

public class Baekjoon_10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N = sc.nextInt();
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			long num = sc.nextLong();
			max = max<num ? num : max;
			min = min>num ? num : min;
		}
		System.out.println(min +" "+max);
	}

}
