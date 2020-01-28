package bak20200128;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	public int x;
	public int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}
public class Baekjoon_7576 {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int[][] box = new int[m][n];
		int[][] visit = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==1)
					visit[i][j] = 1;
				else
					visit[i][j] = 0;
			}
		
		int count = 1;
				
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++){
				if(box[i][j]==1) {
					q.add(new Point(i,j));
					
				}
			}
		}
		while(!q.isEmpty()) {
			Point xy = q.poll();
			int curx = xy.x;
			int cury = xy.y;
			for(int dir = 0;dir<4;dir++) {
				int nx = curx +dx[dir];
				int ny = cury +dy[dir];
				if(nx<0||ny<0||nx>=m||ny>=n) continue;
				if(visit[nx][ny]!=0 || box[nx][ny]==-1) continue;

				q.add(new Point(nx,ny));
				visit[nx][ny] = visit[curx][cury]+1;
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(box[i][j]==-1)
					visit[i][j]=1;
			}
		}
		int max = visit[0][0];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]>max)
					max = visit[i][j];
				if(visit[i][j]==0) {
					max = -1;
					break;
				}
			}
			if(max==-1) break;
		}
		if(max!=-1)
			System.out.println(max-1);
		else
			System.out.println(max);
			
			
		
	}

}
