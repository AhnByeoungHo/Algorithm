package bak20200217;

import java.util.Scanner;

public class Baekjoon_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i=1;
		while(true) {
			
			int temp = 0;
			int num = i;
			while(num>0) {
				temp += num%10;
				num /=10;
			
			}
			//System.out.println(i+" "+temp);
			int total = i + temp;
			if(total==N) break;
			i++;
			if(total>N+63) {
				i=0;
				break;
			}
			
			
		}
		
		System.out.println(i);
	}

}
