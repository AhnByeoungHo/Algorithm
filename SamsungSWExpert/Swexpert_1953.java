package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swexpert_1953 {
	
	static int[][] dx = {
			{-1,0,1,0},
			{-1,0,1,0},
			{0,0,0,0},
			{-1,0,0,0},
			{0,0,1,0},
			{0,0,1,0},
			{-1,0,0,0},
	};
	static int[][] dy = {
			{0,1,0,-1},
			{0,0,0,0},
			{0,1,0,-1},
			{0,1,0,0},
			{0,1,0,0},
			{0,0,0,-1},
			{0,0,0,-1},
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// N, 가로 크기 M, 맨홀 뚜껑이 위치한장소의 세로 위치 R, 가로 위치 C, 그리고 탈출 후 소요된 시간 L
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j*2)-'0';
				}
			}
			
			boolean[][] visit = new boolean[N][M];
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[]{startx, starty,1});
			visit[startx][starty] = true;
			
			while(!q.isEmpty()){
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int curtime = cur[2];
				if(curtime==time) {
					break;
				}
				int dir = map[curx][cury]-1;
				for (int d = 0; d < 4; d++) {
					int nx = curx + dx[dir][d];
					int ny = cury + dy[dir][d];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(map[nx][ny]==0) continue;
					if(visit[nx][ny]) continue;
					
					int ndir = map[nx][ny]-1;
					boolean cango = false;//다음걸로 갈수있는지
					for (int d2 = 0; d2 < 4; d2++) {
						int nnx = nx +dx[ndir][d2];
						int nny = ny + dy[ndir][d2];
						if(nnx<0||nny<0||nnx>=N||nny>=M) continue;
						if(map[nnx][nny]==0) continue;
						if(nnx==curx && nny==cury){
							cango = true;
							break;
						}
					}
					if(cango){
						visit[nx][ny] = true;
						q.add(new int[]{nx,ny,curtime+1});
					}
					
				}
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j]) ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
