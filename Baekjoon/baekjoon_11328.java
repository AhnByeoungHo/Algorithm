package bak20200128;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_11328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int[] alphacountA = new int[26];
			int[] alphacountB = new int[26];
			String a = sc.next();
			String b = sc.next();
			if(a.length()==b.length()) {
				for(int s=0;s<a.length();s++) {
					alphacountA[(a.charAt(s)-'a')]++;
					alphacountB[(b.charAt(s)-'a')]++;
				}
				
			}
			else {
				System.out.println("Impossible");
				continue;
			}
			boolean test = true;
			for(int t=0;t<alphacountA.length;t++) {
				if(alphacountA[t]!=alphacountB[t])
					test = false;
			}
			if(test)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
	}

}
