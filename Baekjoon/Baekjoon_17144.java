package bak20200206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Pair{
//	int x;
//	int y;
//	Pair(int x,int y){
//		this.x = x;
//		this.y = y;
//	}
//}
public class Baekjoon_17144 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static int[] dx_up_air = {-1,0,1,0};
	static int[] dy_up_air = {0,1,0,-1};
	static int[] dx_down_air = {1,0,-1,0};
	static int[] dy_down_air = {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		int[][] map = new int[R][C];
		int[][] copy = new int[R][C];

		Pair[] airP = new Pair[2];
		int hhh=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==-1) {
					airP[hhh] = new Pair(i,j);
					hhh++;
				}
			}
		}

		int count = 0;
		while(count!=T) {

			Queue<Pair> q = new LinkedList<>();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					copy[i][j] = map[i][j];
					if(copy[i][j]>0) {
						q.offer(new Pair(i,j));
					}
				}
			}
			while(!q.isEmpty()) {
				Pair p = q.poll();
				int curx = p.x;
				int cury = p.y;

				int dcount = 0;
				for(int dir=0;dir<4;dir++) {
					int nx = curx +dx[dir];
					int ny = cury +dy[dir];
					if(nx<0||ny<0||nx>=R||ny>=C) continue;
					if(copy[nx][ny]==-1) continue;
					copy[nx][ny] += map[curx][cury]/5;
					dcount++;
				}
				copy[curx][cury] -= map[curx][cury]/5*dcount;
			}
			//위에꺼 상 우 하 좌

			Pair cur = airP[0];
			int curx = cur.x-1;
			int cury = cur.y;
			for(int dir=0;dir<4;dir++) {
				while(true) {
					int nx = curx + dx_up_air[dir];
					int ny = cury + dy_up_air[dir];
					if(nx<0||ny<0||nx==cur.x+1||ny>=C||nx>=R) break;
					if(copy[nx][ny]==-1) break;
					copy[curx][cury] = copy[nx][ny];
					curx = nx;
					cury = ny;
				}
			}
			copy[airP[0].x][airP[0].y+1]=0; 
			//밑에꺼 하 우 상 좌

			cur = airP[1];
			curx = cur.x+1;
			cury = cur.y;
			for(int dir=0;dir<4;dir++) {
				while(true) {
					int nx = curx + dx_down_air[dir];
					int ny = cury + dy_down_air[dir];
					if(nx<0||ny<0||nx==cur.x-1||ny>=C||nx>=R) break;
					if(copy[nx][ny]==-1) break;
					copy[curx][cury] = copy[nx][ny];
					curx = nx;
					cury = ny;
				}
			}
			copy[airP[1].x][airP[1].y+1]=0; 

			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map[i][j] = copy[i][j];
				}
			}
			count++;
		}

//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(copy[i][j]+" ");
//			}
//			System.out.println();
//		}

		int sum = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum += map[i][j];
			}
		}

		
		System.out.println(sum+2);

	}

}
