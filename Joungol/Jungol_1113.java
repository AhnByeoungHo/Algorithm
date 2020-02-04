package jungol;

import java.util.Scanner;
import java.util.Stack;

public class Jungol_1113 {
	static int N,M,endX,endY;
	static int[][] map;
	static int[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new int[N][M];
		endX = sc.nextInt();
		endY = sc.nextInt();
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				map[i][j] = sc.nextInt();
			}
		}
		Stack<Pair> s = new Stack();
		s.push(new Pair(0,0,0));
		int count=1;
		visit[0][0] = count;
		
		
		while(!s.isEmpty()){
			Pair cur = s.pop();
			//System.out.println(cur);
			int curx = cur.x;
			int cury = cur.y;
			int curdir = cur.dir;
			for(int dir=0;dir<4;dir++){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				//System.out.println(nx +" "+ny);
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(visit[nx][ny] <= visit[curx][cury] && visit[nx][ny]!=0) continue;
				if(map[nx][ny]==0) continue;
				if(curdir==dir||(curx==0&&cury==0))
					visit[nx][ny] = visit[curx][cury];
				else
					visit[nx][ny] = visit[curx][cury]+1;
				s.push(new Pair(nx,ny,dir));
			}
			
		}
		
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				System.out.print(visit[i][j]+ "\t");
//			}
//			System.out.println();
//		}
		
		System.out.println(visit[endX][endY]-1);
		
		
	}
	static class Pair{
		int x;
		int y;
		int dir;
		Pair(int x, int y,int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + "," + y;
		}
	}

}
