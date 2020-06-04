package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_16929 {
	static boolean over = false;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int[][] visit;
	private static int N;
	private static int M;
	private static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(over) break;
				visit = new int[N][M];
				visit[i][j] = 1;
				dfs(i,j,1);
			}
			if(over) break;
		}
		if(over) System.out.println("Yes");
		else System.out.println("No");
	}
	private static void dfs(int i, int j, int cost) {
		if(over) return;
		for (int dir = 0; dir < 4; dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(map[nx][ny]!=map[i][j]) continue;
			if(visit[nx][ny]==0){
				visit[nx][ny]=cost;
				dfs(nx, ny, cost+1);
				visit[nx][ny]=0;
			} else {
				if(Math.abs(visit[nx][ny]-cost)>=3){
					over = true;
					return;
				}
			}
		}
		
	}
}
