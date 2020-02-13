package bak20200213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swexpert_1861_D4 {

	private static int N;
	private static int[][] map;
	private static int[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visit = new int[N][N];
			int max = 0;
			int start = Integer.MAX_VALUE;
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					Pair smallstart = new Pair(i,j);
					if(visit[i][j]==0) {
						int count=1;
						Queue<Pair> q = new LinkedList<>();
						q.offer(new Pair(i,j));
						visit[i][j]=count;
						
						while(!q.isEmpty()) {
							Pair cur = q.poll();
							int curx = cur.x;
							int cury = cur.y;
							//System.out.println(curx+ " "+cury);
							for(int dir=0;dir<4;dir++) {
								int nx = curx + dx[dir];
								int ny = cury + dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(visit[nx][ny]!=0) continue;
								if(Math.abs(map[curx][cury]-map[nx][ny])!=1) continue;
								
								q.offer(new Pair(nx,ny));
								visit[nx][ny] = ++count;
								if(map[curx][cury]>map[nx][ny])
									smallstart = new Pair(nx,ny);
							}	
						}
						if(count==1)
							visit[i][j] = -1;
						if(count>=max) {
							if(count==max) {
								if(map[smallstart.x][smallstart.y]<start&&visit[smallstart.x][smallstart.y]!=-1)
									start = map[smallstart.x][smallstart.y];
							}
							else {
								max = count;
								start = map[smallstart.x][smallstart.y];
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+start+" "+max);
		}
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
