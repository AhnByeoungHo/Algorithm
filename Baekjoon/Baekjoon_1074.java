package bak20200130;

import java.util.Scanner;

public class Baekjoon_1074 {

	static int idx=0;
	//static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = (int) Math.pow(2, N);
		//map = new int[K][K];
		int r =sc.nextInt();
		int c = sc.nextInt();
		func(1, 1, K ,4,r,c);
		//p(map);
		//System.out.println(map[r][c]);
	}
	public static void func(int startX,int startY,int N,int k,int r,int c) {
		//System.out.println(startX + " " + startY + " " + N + " "+ k);
		if(N <=2) {
			if((startX-1)==r&&(startY-1==c)) {
				System.out.println(idx);
				System.exit(0);
			}

			else if((startX-1)==r&&(startY==c)){
				System.out.println(idx+1);
				System.exit(0);
			}
			else if((startX)==r&&(startY-1==c)) {
				System.out.println(idx+2);
				System.exit(0);
			}
			else if((startX)==r&&(startY==c)) {
				System.out.println(idx+3);
				System.exit(0);
			}
			idx+=4; //밑에 주석지우면 이거 주석필요
			//map[startX-1][startY-1] = (int) (idx++%(Math.pow(4, k)));
			//map[startX-1][startY] = (int) (idx++%(Math.pow(4, k)));
			//map[startX][startY-1] = (int) (idx++%(Math.pow(4, k)));
			//map[startX][startY] = (int) (idx++%(Math.pow(4, k)));
			//p(map);
			//System.out.println("===================");
			return;
		}
		else {
			func(startX, startY,  N/2,k,r,c);	
			func(startX, startY+N/2,  N/2,k,r,c);
			func(startX + N/2, startY,  N/2,k,r,c);
			func(startX + N/2, startY+N/2, N/2,k,r,c);		
		}
	}
	public static void p(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j] +"\t");
			}
			System.out.println();
		}
	}

}
