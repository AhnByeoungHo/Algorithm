package bak20200204;

import java.util.Scanner;

public class Baekjoon_13458 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long ans = 0;
		
		int N = sc.nextInt();
		int[] room = new int[N];
		for(int i=0;i<N;i++) {
			room[i] = sc.nextInt();
			ans++;
		}
			
		int master = sc.nextInt();
		int sub = sc.nextInt();
		
		for(int i=0;i<N;i++)
		{
			room[i] -= master;
			int temp = room[i]/sub;
			int temp2 = room[i]%sub;
			if(room[i]<=0) continue;
			
			//System.out.println(temp + " "+ temp2);
			//room[i] -= temp*sub;
			if(temp2==0)
				ans = ans + temp;
			else
				ans = ans + temp + 1;
		}
		System.out.print(ans);
	}

}
