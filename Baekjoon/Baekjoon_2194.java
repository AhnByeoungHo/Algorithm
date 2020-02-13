package bak20200213;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2194 {

	private static int N;
	private static int M;
	private static int sero;
	private static int garo;
	private static int[][] map;
	private static int startX;
	private static int startY;
	private static int endX;
	private static int endY;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int[][] visit;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new int[N][M];
		
		sero = sc.nextInt();
		garo = sc.nextInt();
		int K  =sc.nextInt();
		for(int i=0;i<K;i++) {
			int wallx = sc.nextInt()-1;
			int wally = sc.nextInt()-1;
			map[wallx][wally] = -1;
		}
		startX = sc.nextInt()-1;
		startY = sc.nextInt()-1;
		endX = sc.nextInt()-1;
		endY = sc.nextInt()-1;
		
		Queue<Pair> q = new LinkedList<>();
		
		q.offer(new Pair(startX, startY));
		visit[startX][startY] = 1;

		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			//System.out.println(curx + " " + cury);
			
			if(curx==endX&&cury==endY) break;
			for(int dir=0;dir<4;dir++) {
				int nx = curx+dx[dir];
				int ny = cury+dy[dir];
				if(nx<0||ny<0||ny+garo-1>=M||nx+sero-1>=N) {
					continue;
				}
				//up nx all ny
				if(visit[nx][ny]!=0) {
					continue;
				}
				boolean cango = true;
				for(int a=nx;a<nx+sero;a++) {
					for(int s=ny;s<ny+garo;s++) {
						if(map[a][s]==-1) {
							cango = false;
							break;
						}
					}
				}
				if(!cango) continue;
				
				
				q.offer(new Pair(nx,ny));
				visit[nx][ny] = visit[curx][cury]+1;
			}
			
		}
		System.out.println(visit[endX][endY]-1);

	}
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}
