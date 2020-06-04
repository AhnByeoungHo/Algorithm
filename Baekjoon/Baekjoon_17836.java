package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17836 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] visit = new boolean[2][N][M];
		q.add(new int[]{0,0,0,0});
		visit[0][0][0] = true;
		
		int ans = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curx = cur[0];
			int cury = cur[1];
			int curt = cur[2];
			int hassword = cur[3];
			if(curx==N-1&&cury==M-1){
				ans = curt;
				break;
			}
			if(curt>T){
				ans = 0;
				break;
			}
			if(hassword==0){
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(map[nx][ny]==1)continue;
					if(visit[0][nx][ny]) continue;
					if(map[nx][ny]==2){
						q.add(new int[]{nx,ny,curt+1,1});
						visit[1][nx][ny] = true;
					} else {
						q.add(new int[]{nx,ny,curt+1,0});
						visit[0][nx][ny] = true;
					}
				}
			} else {
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(visit[1][nx][ny]) continue;
					
					q.add(new int[]{nx,ny,curt+1,1});
					visit[1][nx][ny] = true;
				}
			}
			
		}
		if(ans==0) System.out.println("Fail");
		else System.out.println(ans);
	}
}
