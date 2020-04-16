package bak;

import java.util.Scanner;

public class Baekjoon_11726and11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//2x2 2
		//2x3 4
		//2x4 
		int[] fibo = new int[n+2];
		int[] fibo3 = new int[n+2];
		fibo[1] = 1;
		fibo3[1] = 1;
		fibo3[2] = 3;
		for(int i=2;i<n+2;i++){
			fibo[i] = (fibo[i-1] + fibo[i-2])%10007;
			fibo3[i] = (fibo3[i-1] + fibo3[i-2]*2)%10007;
		}
		System.out.println(fibo[n+1]);

		System.out.println(fibo3[n+1]);
	}
}
