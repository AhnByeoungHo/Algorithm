package bak20200128;

import java.util.Scanner;

public class baekjoon_13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = sc.nextInt();
		int[][] all = new int[2][7];
		
		for(int i=0;i<N;i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			all[gender][grade]++;
		}
		int roomcount = 0;
		for(int i=0;i<all.length;i++) {
			for(int j=0;j<all[0].length;j++) {
				if(all[i][j]!=0) {
					if(all[i][j]%max==0)
						roomcount += (all[i][j]/max);
					else
						roomcount += (all[i][j]/max)+1;
				}
				
			}

		}
		
		System.out.println(roomcount);
	}

}
