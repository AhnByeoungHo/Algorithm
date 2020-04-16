package bak;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2579 {
	private static int N;
	private static long[] dp;
	private static int[] step;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new long[N];
		step = new int[N];
		for (int i = 0; i < N; i++) {
			step[i] = sc.nextInt();
		}
		if(N==1) System.out.println(step[0]);
		else{
			dp[0] = step[0];
			dp[1] = step[1] + step[0];
			if(N>=3){
				dp[2] = Math.max(step[0], step[1]) + step[2]; 
				if(N>=4){
					for (int i = 3; i < N; i++) {
						dp[i] = Math.max(step[i] + dp[i-2], step[i] + step[i-1] + dp[i-3]);
					}			
				}
			}
			System.out.println(dp[N-1]);
		}
	}
}
