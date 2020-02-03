package work20200203;

import java.util.Arrays;
import java.util.Stack;

public class Backtracking {
	static int[][] map = {
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0},
	};
	static int[]dx = {-1,0,1,0};;
	static int[]dy = {0,1,0,-1};;
	static int[][] visit;
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		maze();
	}
	public static void maze() {
		Stack<Point> s = new Stack();
		visit = new int[8][8];
		s.push(new Point(0,0));
		
		int c = 1;
		int n = 1;
		visit[0][0]=c++;
		while(!s.isEmpty()) {
			int curx = s.peek().x;
			int cury = s.peek().y;
			if(curx==7&&cury==7) {
				System.out.println("Goal!!!");
				break;
			}
			System.out.println(curx + " " + cury);
			s.pop();
			if(map[curx][cury]==0) {
				for(int dir=0;dir<4;dir++) {
					int tempx = curx;
					int tempy = cury;
					while(true) {
						int nx = tempx + dx[dir];
						int ny = tempy + dy[dir];
						if(nx<0||ny<0||nx>=8||ny>=8) break;
						if(visit[nx][ny]!=0||map[nx][ny]==1) break;
						s.push(new Point(nx,ny));
						visit[nx][ny] = c++;
						tempx = nx;
						tempy = ny;
					}
				}
			}
			
		}
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(visit[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("================================================================");

	}

}
