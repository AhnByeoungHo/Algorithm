package bak20200213;

import java.util.Scanner;

public class Baekjoon_9625 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int firstA = 1;
		int secondB = 0;
		
		for(int i=1;i<=k;i++) {
			int tempA = firstA;
			int tempB = secondB;
			secondB = tempB + tempA;
			firstA = tempB;
		}
		System.out.println(firstA+" "+secondB);
	}

}
