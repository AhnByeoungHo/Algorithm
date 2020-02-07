package bak20200207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1120 {

	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		
		for(int i=0;i<str2.length()-str1.length()+1;i++) {
			int count = 0;
			for(int j=i;j<str1.length()+i;j++) {
				if(str1.charAt(j-i)!=str2.charAt(j)) {
					count++;
				}
			}
			ans = Math.min(ans, count);
		}
		System.out.println(ans);
	}
}
