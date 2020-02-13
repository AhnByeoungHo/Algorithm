package bak20200213;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_9946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ca = 1;
		while(true) {
			String first = sc.next();
			String second = sc.next();
			if(first.equals("END")&&second.equals("END")) break;
			
			int[] countA = new int[26];
			int[] countB = new int[26];
			for(int i=0;i<first.length();i++) {
				countA[first.charAt(i)-'a']++;
				countB[second.charAt(i)-'a']++;
			}
			boolean end = false;
			for(int i=0;i<26;i++) {
				if(countA[i]!=countB[i]) {
					System.out.println("Case "+(ca++)+": different");
					end = true;
					break;
				}
			}
			if(!end)
				System.out.println("Case "+(ca++)+": same");
		}
	}

}
