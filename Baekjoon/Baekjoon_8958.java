package bak20200207;

import java.util.Scanner;

public class Baekjoon_8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String str = sc.next();
			int count = 0;
			int score = 0;
			for(int c =0;c<str.length();c++) {
				if(str.charAt(c)=='O') count++;
				if(str.charAt(c)=='X') count =0;
				score += count;
			}
			System.out.println(score);
		}
	}

}
