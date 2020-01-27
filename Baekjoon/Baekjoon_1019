package work20200122;

import java.util.Scanner;

public class Baekjoon_1019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int[] count = new int[10];
		
		for(long i=1;i<=N;i++) {
			long num = i;
			System.out.println(num);
			while(num!=0) {
				
				long temp = num%10;
				count[(int) temp]++;
				num/=10;
			}
		}
		for(int i=0;i<10;i++)
			System.out.print(count[i] + " ");
	}

}
