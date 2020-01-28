package bak20200128;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//not solve
class Point2{
	public int x;
	public int y;
	public int z;
	public Point2(int k, int i, int j) {
		// TODO Auto-generated constructor stub
		this.x=i;
		this.y=j;
		this.z=k;
	}
	
}
public class Baekjoon_7569 {

	static int[] dx = {1,0,-1,0,0,0};
	static int[] dy = {0,1,0,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int[][][] box = new int[s][m][n];
		int[][][] visit = new int[s][m][n];
		for(int k=0;k<s;k++) {
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++) {
					box[k][i][j] = sc.nextInt();
					if(box[k][i][j]==1)
						visit[k][i][j] = 1;
					else
						visit[k][i][j] = 0;
				}
		}
		
		
		int count = 1;
				
		Queue<Point2> q = new LinkedList<Point2>();
		for(int k=0;k<s;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++){
					if(box[k][i][j]==1) {
						q.add(new Point2(k,i,j));
						
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point2 xy = q.poll();
			int curx = xy.x;
			int cury = xy.y;
			int curz = xy.z;
			for(int dir = 0;dir<6;dir++) {
				int nx = curx +dx[dir];
				int ny = cury +dy[dir];
				int nz = curz +dz[dir];
				if(nx<0||ny<0||nz<0||nz>=s||nx>=m||ny>=n) continue;
				if(visit[nz][nx][ny]!=0 || box[nz][nx][ny]==-1) continue;

				q.add(new Point2(nz,nx,ny));
				visit[nz][nx][ny] = visit[curz][curx][cury]+1;
			}
		}
		for(int k=0;k<s;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(box[k][i][j]==-1)
						visit[k][i][j]=1;
				}
			}
		}
		
		int max = visit[0][0][0];
		for(int k=0;k<s;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(visit[k][i][j]>max)
						max = visit[k][i][j];
					if(visit[k][i][j]==0) {
						max = -1;
						break;
					}
				}
				if(max==-1) break;
			}
		}
		
		print(visit);
		if(max!=-1)
			System.out.println(max-1);
		else
			System.out.println(max);
			
			
		
	}
	public static void print(int[][][] visit) {
		for(int k=0;k<visit.length;k++) {
			for(int i=0;i<visit[0].length;i++) {
				for(int j=0;j<visit[0][0].length;j++) {
					System.out.print(visit[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
