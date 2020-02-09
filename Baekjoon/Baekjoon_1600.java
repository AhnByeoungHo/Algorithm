package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1600 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static int[] dx = {-1,0,1,0,-2,-1,1,2,2,1,-1,-2};
	private static int[] dy = {0,1,0,-1,1,2,2,1,-1,-2,-2,-1};
	private static int ans = Integer.MAX_VALUE;
	private static boolean[][][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(s.nextToken());
		N = Integer.parseInt(s.nextToken());

		map = new int[N][M];
		visit = new boolean[32][N][M];
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		//visit[1][0][0] = true;

		//dfs(0,0,new Monkey(0,0,0,0));

		ans = -1;
		Queue<Monkey> q = new LinkedList<>();
		q.offer(new Monkey(0, 0, 0, 0));
		visit[0][0][0] = true;

		while(!q.isEmpty()){
			Monkey cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			int curjump = cur.jumpCount;
			int curhorse = cur.jump_Horse_Count;
			if(curx==N-1&&cury==M-1) {
				ans = curjump;
				break;
			}

			if(curhorse<K){
				for(int dir=4;dir<12;dir++){
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(visit[curhorse+1][nx][ny]) continue;
					if(map[nx][ny]==1) continue;
					q.offer(new Monkey(nx, ny, curjump+1, curhorse+1));
					visit[curhorse+1][nx][ny] = true;

				}
			}

			for(int dir=0;dir<4;dir++){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(visit[curhorse][nx][ny]) continue;
				if(map[nx][ny]==1) continue;
				q.offer(new Monkey(nx, ny, curjump+1, curhorse));
				visit[curhorse][nx][ny] = true;


			}

		}


		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	public static class Monkey{
		int x;
		int y;
		int jumpCount;
		int jump_Horse_Count;
		public Monkey(int x, int y, int jumpCount, int jump_Horse_Count) {
			super();
			this.x = x;
			this.y = y;
			this.jumpCount = jumpCount;
			this.jump_Horse_Count = jump_Horse_Count;
		}

	}
	public static void printMap(){
		for(int i=0;i<N;i++)
			System.out.println(Arrays.toString(map[i]));
	}
	public static void dfs(int x,int y, Monkey m){
		//System.out.println(x + " "+ y);
		if(x<0||x>=N||y<0||y>=M) return;
		if(map[x][y]==1) return;
		if(visit[0][x][y] && visit [1][x][y]) return;
		if(m.jump_Horse_Count==K && m.jumpCount>=ans) return;
		if(m.jump_Horse_Count>K)return;
		if(x==N-1&&y==M-1){
			if(m.jumpCount<ans) ans = m.jumpCount;
			return;
		}
		else{
			for(int dir=11;dir>=0;dir--){
				int nx = x +dx[dir];
				int ny = y +dy[dir];
				if(!(nx<0||nx>=N||ny<0||ny>=M)){
					if(dir<4) {
						if(!visit[0][nx][ny]){
							visit[0][nx][ny] = true;
							dfs(nx,ny, new Monkey(nx, ny, m.jumpCount+1, m.jump_Horse_Count));
							visit[0][nx][ny] = false;

						}
					}

					else{
						if(!visit[1][nx][ny]){
							visit[1][nx][ny] = true;
							dfs(nx,ny,new Monkey(nx,ny,m.jumpCount+1,m.jump_Horse_Count+1));
							visit[1][nx][ny] = false;

						}
					}
				}


			}
		}
	}
}


