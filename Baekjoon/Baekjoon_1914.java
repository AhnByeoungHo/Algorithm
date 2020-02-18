package bak20200218;

import java.math.BigInteger;
import java.util.Scanner;

public class Baekjoon_1914 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		BigInteger b = new BigInteger("2").pow(N).subtract(BigInteger.ONE);

		sb.append(b).append("\n");
		if(N>20) 
			System.out.println(sb);
		else {
			hanoi(N, 1, 2, 3);
			System.out.println(sb);
		}
		
	}
	public static void hanoi(int n, int from, int to, int where) {
		if(n==0) return;
		else
		{
			hanoi(n-1, from, where, to);
			sb.append(from).append(" ").append(where).append("\n");
			hanoi(n-1, to, from, where);
		}
	}

}
