package bak20200128;

import java.util.Scanner;

public class baekjoon_1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(function(N,k));
	}
	public static int function(int N,int k) {
		if(N==1) {
			
			return 1;
		}
		System.out.println((function(N-1,k) + k -1)%N +1);
		return (function(N-1,k) + k -1)%N +1;

	}

}
