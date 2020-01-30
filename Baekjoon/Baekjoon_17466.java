package bak20200130;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_17466 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		long result = 1;
		for(int i=0;i<n-1;i++) {
			result = ((result)*((i+2)))%p;
		}
		//System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}

}
