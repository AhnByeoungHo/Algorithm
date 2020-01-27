package baekjoon;

import java.util.Scanner;

public class baekjoon_1629 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int result = func(A,B,A%C,0,C);
		System.out.println(result);
	}
	public static int func(int A,int B,int _A, int _B, int C) {
		if(B==_B)
			return _A%C;
		int temp = (int)((_A%C * A%C));
		return func(A,B,temp,_B+1,C)%C;
	}
}
