package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaltInsect {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res\\Solution21.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] go = {3,2,1};
		
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int number = sc.nextInt();
			int[][] water = new int[N][N];
			boolean isPrint = false;
			for(int insect = 1;insect<=number;insect++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int direction = sc.nextInt();//down:1 right:2
				water[x][y]++;
				
				if(direction==1) {
					for(int dir=0;dir<3;dir++) {
						int nx = x + go[dir];
						if(nx>=N) break;
						if(water[nx][y] == 1) {
							System.out.println("#"+tc+" "+insect);
							isPrint = true;
							break;
						}
						water[nx][y]++;
						x = nx;
					}
				}
				else if(direction==2) {
					for(int dir=0;dir<3;dir++) {
						int ny = y + go[dir];
						if(ny>=N) break;
						if(water[x][ny] == 1) {
							System.out.println("#"+tc+" "+insect);
							isPrint = true;
							break;
						}
						water[x][ny]++;
						y = ny;
					}
				}	
			}
			if(!isPrint) {
				System.out.println("#"+tc+" 0");
			}	
		}
	}

}
