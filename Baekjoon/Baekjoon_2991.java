package bak20200207;

import java.util.Scanner;

public class Baekjoon_2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int[] arr = new int[3];
		for(int i=0;i<3;i++)
			arr[i] = sc.nextInt();
		
		int firstdog = A+B;
		int seconddog = C+D;
		for (int i = 0; i < arr.length; i++) {
			int attack = 0;
			int fir = arr[i]%firstdog;
			int sec = arr[i]%seconddog;
			if(fir <= A && fir!=0) attack++;
			if(sec <= C && sec!=0) attack++;
			System.out.println(attack);
			
		}
		
	
	}

}
