package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Robot {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res\\Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1;tc<=T;tc++) {
			int ans = 0;
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			//System.out.println(Arrays.deepToString(map));
			int[] da = {1};
			int[] db = {-1,1};
			int[] dcx = {0,-1,0,1};
			int[] dcy = {-1,0,1,0};
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]=='A') {
						int curj = j;
						while(true) {
							int nj = curj+da[0];
							if(nj>=N) break;
							if(map[i][nj]!='S') break;
							curj=nj;
							ans++;
						}
						//System.out.println("A"+ans);	
					}
					else if(map[i][j]=='B') {
						for(int s=0;s<2;s++) {
							int curj = j;
							while(true) {
								int nj = curj+db[s];
								if(nj>=N||nj<0) break;
								if(map[i][nj]!='S') break;
								curj=nj;
								ans++;
							}
						}				
						//System.out.println("B"+ans);
					}
					else if(map[i][j]=='C') {
						for(int s=0;s<4;s++) {
							int curi = i;
							int curj = j;
							while(true) {
								int ni = curi+dcx[s];
								int nj = curj+dcy[s];
								if(nj>=N||ni>=N||nj<0||ni<0) break;
								if(map[ni][nj]!='S') break;
								curi=ni;
								curj=nj;
								ans++;
							}
						}
						//System.out.println("C"+ans);
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}

}
