package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution13 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res\\Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int mapSz = sc.nextInt();
			char [][] map = new char[mapSz][mapSz];
			int[][] building = new int[mapSz][mapSz];
			for(int i=0;i<mapSz;i++) {
				for(int j=0;j<mapSz;j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			int[] dx = {-1,-1,0,1,1,1,0,-1};
			int[] dy = {0,1,1,1,0,-1,-1,-1};
			
			for(int i=0;i<mapSz;i++) {
				for(int j=0;j<mapSz;j++) {
					if(map[i][j]=='B') {
						boolean canBuild = true;
						for(int dir=0;dir<8;dir++) {
							int nx = i +dx[dir];
							int ny = j +dy[dir];
							if(nx<0||ny<0||nx>=mapSz||ny>=mapSz) continue;
							if(map[nx][ny]=='G') {
								building[i][j]=2;
								canBuild = false;
								break;
							}
						}		
						if(canBuild) {
							for(int a =0;a<mapSz;a++) {
								if(map[i][a]=='B')
									building[i][j]++;
							}
							for(int a =0;a<mapSz;a++) {
								if(map[a][j]=='B')
									building[i][j]++;
							}
							building[i][j]--;
						}
					}
				}
			}
			int max = -1;
			for(int i=0;i<mapSz;i++) {
				for(int j=0;j<mapSz;j++) {
					if(max<building[i][j])
						max = building[i][j];
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

}
