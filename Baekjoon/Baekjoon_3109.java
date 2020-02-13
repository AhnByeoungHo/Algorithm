package bak20200213;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_3109 {

	private static char[][] map;
	private static boolean[][] visit;

	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	private static int N;
	private static int M;
	static int max =0;
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visit = new boolean[N][M];
		for(int j=0;j<N;j++) {
			flag = false;
			//System.out.println(j+"1111111");
			visit[j][0]=true;
			dfs(j,0);
		}

		int sum=0;
		for(int i=0;i<N;i++) {
			if(visit[i][M-1])
				sum++;
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println(sum);
	}

	private static void dfs(int x, int y) {
		if(flag) return;
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(visit[i]));
//		}
//		System.out.println(x+" "+y);

		if(y==M-1) {
			flag = true;
			return;
		}
		
		{

			for(int dir=0;dir<3;dir++) {
				int nx=x+dx[dir];
				int ny=y+dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(map[nx][ny]=='x') continue;
				if(!visit[nx][ny]) {
					visit[nx][ny]=true;
					dfs(nx,ny);
					if(flag) return;
					//visit[nx][ny]=false;
				}
				
			}
			
		}
		
	}


}
