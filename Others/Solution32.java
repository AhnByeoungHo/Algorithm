package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution32 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res\\Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int personNum = sc.nextInt();
			int[][] map = new int[N][M];
			int[][] person_XY_jumNum = new int[personNum][3];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<personNum;i++) {
				for(int j=0;j<3;j++) 
					person_XY_jumNum[i][j] = sc.nextInt();
				ans-=1000;
			}
		int trapNum = sc.nextInt();
			for(int i=0;i<trapNum;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x-1][y-1] = 0;
			}
			for(int i=0;i<personNum;i++) {
				boolean fail = false;
				int startX = person_XY_jumNum[i][0];
				int startY = person_XY_jumNum[i][1];
				int gameNum = person_XY_jumNum[i][2];
				int curx = startX-1;
				int cury = startY-1;
				for(int game=0;game<gameNum;game++){
					int dir = map[curx][cury]/10;
					int stepOnetime = map[curx][cury]%10;
					int nx = curx + dx[dir-1]*stepOnetime;
					int ny = cury + dy[dir-1]*stepOnetime;
					if(nx<0||ny<0||nx>=N||ny>=M) {
						fail=true;
						break;
					}
					if(map[nx][ny]==0) {
						fail=true;
						break;
					}
					curx = nx;
					cury = ny;
				}
//				System.out.println("personNum"+(i+1)+" "+curx+" "+cury);
				if(!fail) {
//					System.out.println("personNum"+(i+1)+" success");
//					System.out.println("상금: " + map[curx][cury]*100);
					ans+=map[curx][cury]*100;
				}	
//				else {
//					System.out.println("personNum"+(i+1)+" fail");
//				}
//				System.out.println();		
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}
