package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res\\Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] go = {3,2,1};
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int number = sc.nextInt();
			int[][] water = new int[N][N];
			int dead = 0;
			for(int insect = 1;insect<=number;insect++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int direction = sc.nextInt();//down:1 right:2

				if(direction==1) {
					for(int dir=0;dir<3;dir++) {
						int nx = x - go[dir];
						if(nx<0) {
							dead++;
							break;
						}
						if(water[nx][y]!=0) {
							dead++;
							break;
						}
						x = nx;
						if(dir==2) {
							water[x][y]++;
						}
					}
				}
				else if(direction==2) {
					for(int dir=0;dir<3;dir++) {
						int nx = x + go[dir];
						if(nx>=N) {
							dead++;
							break;
						}
						if(water[nx][y]!=0) {
							dead++;
							break;
						}
						x = nx;
						if(dir==2) {
							water[x][y]++;
						}
					}
				}	
				else if(direction==3) {
					for(int dir=0;dir<3;dir++) {
						int ny = y - go[dir];
						if(ny<0) {
							dead++;
							break;
						}
						if(water[x][ny]!=0) {
							dead++;
							break;
						}
						y = ny;
						if(dir==2) {
							water[x][y]++;
						}
					}
				}
				else if(direction==4) {
					for(int dir=0;dir<3;dir++) {
						int ny = y + go[dir];
						if(ny>=N) {
							dead++;
							break;
						}
						if(water[x][ny]!=0) {
							dead++;
							break;
						}
						y = ny;
						if(dir==2) {
							water[x][y]++;
						}
					}
				}	
			}
			System.out.println("#"+tc+" "+ (number-dead));
		}
		
	}

}
