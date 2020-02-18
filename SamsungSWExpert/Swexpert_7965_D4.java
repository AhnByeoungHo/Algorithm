package bak20200218;

import java.math.BigInteger;
import java.util.Scanner;

public class Swexpert_7965_D4 {

	private static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();

			long ans= 0;
			long i=1;
			while(i<=N) {
				long num = rePow(i,i)%1000000007;
				//System.out.println(num);
				ans = (ans+num)%1000000007;
				i++;
			}
			System.out.println("#"+tc+" "+ ans);
		}
	}
	private static long rePow(long n, long k) {
		// TODO Auto-generated method stub
		if(k==1) return n;
		if(k%2==0) {
			long temp = (rePow(n, k/2)%1000000007);
			return (temp*temp)%1000000007;
		}
		else {
			long temp = (rePow(n, (k-1)/2)%1000000007);
			return (((temp*temp) % 1000000007)*n)%1000000007;
		}
	}

}
