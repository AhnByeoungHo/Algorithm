package bak20200211;

import java.util.Scanner;

public class Baekjoon_14501 {

	private static int[] P;
	private static int[] T;
	static int ans = 0;
	private static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N+1];
		P = new int[N+1];
		for(int i=1;i<N+1;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=1;i<N+1;i++) {
			dfs(i,0);
		}
		System.out.println(ans);
		
	}
	public static void dfs(int start,int sum) {
		
		if(start + T[start]==N+1) {
			sum+=P[start];
			if(sum>ans) ans = sum;
			return;
		}
		if(start + T[start]>N+1) {
			if(sum>ans) ans = sum;
			return;
		}
		else {

			for(int i=start;i<N+1;i++) {
				if(i+T[start]<N+1)
					dfs(i+T[start], sum+P[start]);
			}
		}
		
	}

}
