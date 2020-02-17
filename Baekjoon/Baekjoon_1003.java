package bak20200217;

import java.util.Scanner;

public class Baekjoon_1003 {
	static int[] arr = new int[42];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<42;i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			if(N==0)System.out.println("1 0");
			else if(N==1)System.out.println("0 1");
			else System.out.println(arr[N-2]+ " " +arr[N-1]);
		}

	}

}