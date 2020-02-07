package bak20200207;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		int score = 0;
		for(int i=1;i<=n;i++) {
			//int temp = 0;
			for(int j=0;j<i;j++) {
				score += arr[j];
				//temp+=arr[j];
			}
			//System.out.println(temp);
		}
		System.out.println(score);
	}
}
