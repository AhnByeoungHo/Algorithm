package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2468 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		int maxheight = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(maxheight<map[i][j]) maxheight = map[i][j];
			}
		}
		
		int ans = 0;
		for (int m = 0; m < maxheight; m++) {
			int[][] copy = new int[N][N];
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if(map[a][b]>m)
						copy[a][b] = map[a][b];
				}
			}
			
			boolean[][] visit = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(copy[i][j]!=0 && !visit[i][j]){
						count++;
						Queue<int[]> q = new LinkedList<int[]>();
						visit[i][j] = true;
						q.add(new int[]{i,j});
						
						while(!q.isEmpty()){
							int[] cur = q.poll();
							int curx = cur[0];
							int cury =cur[1];
							
							for (int dir = 0; dir < 4; dir++) {
								int nx = curx + dx[dir];
								int ny = cury + dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(visit[nx][ny]) continue;
								if(copy[nx][ny]==0) continue;
								visit[nx][ny] = true;
								q.add(new int[]{nx,ny});
							}
						}
					}
				}
			}
			ans = Math.max(ans, count);
		}
		System.out.println(ans);
	}
}
