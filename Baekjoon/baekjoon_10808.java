package bak20200128;

import java.util.Scanner;

public class baekjoon_10808 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] ccount = new int[26];

		for(int i=0;i<str.length();i++) {
			ccount[str.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			System.out.print(ccount[i] + " ");
		}
	}

}
