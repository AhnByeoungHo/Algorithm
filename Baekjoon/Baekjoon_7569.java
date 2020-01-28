package bak20200128;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m = sc.nextInt();
		int h = sc.nextInt();
		int[][][] box = new int[h][m][n];
		int[][][] visit = new int[h][m][n];
		Queue<Point2> q = new LinkedList<Point2>();
		for(int k=0;k<h;k++) {
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++) {
					box[k][i][j] = sc.nextInt();
					if(box[k][i][j]==1){
						visit[k][i][j] = 1;
						q.add(new Point2(k,i,j));
					}
					else
						visit[k][i][j] = 0;
				}
		}
		
		
		int count = 1;
				
		while(!q.isEmpty()) {
			Point2 xy = q.remove();
			int curx = xy.x;
			int cury = xy.y;
			int curz = xy.z;
			for(int dir = 0;dir<6;dir++) {
				int nx = curx +dx[dir];
				int ny = cury +dy[dir];
				int nz = curz +dz[dir];
				if(nx<0||ny<0||nz<0||nz>=n||nx>=h||ny>=m) continue;
				if(visit[nx][ny][nz]!=0 || box[nx][ny][nz]==-1) continue;

				q.add(new Point2(nx,ny,nz));
				visit[nx][ny][nz] = visit[curx][cury][curz]+1;
			}
		}

		
		int max = 0;
		for(int k=0;k<h;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(visit[k][i][j]>max)
						max = visit[k][i][j];
				}
			}
		}
		
		for(int k=0;k<h;k++) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(box[k][i][j]==-1 && visit[k][i][j]==0)
						max = -1;
				}
			}
		}
		System.out.println(max);		
	}

}
