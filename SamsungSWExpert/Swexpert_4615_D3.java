package bak20200207;

import java.util.Scanner;


public class Swexpert_4615_D3 {

	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int N;
	static char[][] map;
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc= 1;tc<=T;tc++) {
			N = sc.nextInt();
			map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = 'o';
				}
			}
			map[N/2-1][N/2-1] = 'W';
			map[N/2-1][N/2] = 'B';
			map[N/2][N/2-1] = 'B';
			map[N/2][N/2] = 'W';
			int M = sc.nextInt();
			//System.out.println();
			for(int turn=0;turn<M;turn++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				int bw = sc.nextInt(); //b=1 w=2
				if(bw==1)
					map[x][y] = 'B';
				else if(bw==2)
					map[x][y] = 'W';
				
				for(int dir=0;dir<8;dir++) {
					flag = false;
					dfs(map, bw, x+dx[dir], y+dy[dir],dir);
				}
				
				
				//printMap(map);
				//System.out.println();
			}
			
			int Bcount =0;
			int Wcount = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]=='B') Bcount++;
					if(map[i][j]=='W') Wcount++;
				}
			}
			System.out.println("#"+tc+ " " +Bcount + " " + Wcount);
			//printMap(map);
		}
		
				
	}
	private static void dfs(char[][] map, int bw,int x,int y,int dir) {
		if(bw==1) {
			if(x<0||y<0||x>=N||y>=N) {
				flag = false;
				return;
			}
			if(map[x][y]=='o') {
				flag = false;
				return;
			}
			if(map[x][y]=='B') {
				flag = true;
				return;
			}
			dfs(map, bw, x+dx[dir], y+dy[dir],dir);
			if(flag)
				map[x][y] = 'B';
			
		}
		else {
			if(x<0||y<0||x>=N||y>=N) {
				flag = false;
				return;
			}
			if(map[x][y]=='o') {
				flag = false;
				return;
			}
			if(map[x][y]=='W') {
				flag = true;
				return;
			}
			dfs(map, bw, x+dx[dir], y+dy[dir],dir);
			if(flag)
				map[x][y] = 'W';
				
		}
		
	}
	public static void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
