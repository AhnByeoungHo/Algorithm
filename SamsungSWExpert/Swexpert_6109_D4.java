package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_6109_D4 {
	private static int N;
	private static int[][] map;
	private static boolean[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				StringTokenizer line = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(line.nextToken());
				}
			}
			if(dir.equals("up")){
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						move(j, i, 0);
					}
				}
			} else if(dir.equals("left")){
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						move(i, j, 1);
					}
				}
			} else if(dir.equals("down")){
				for (int i = 0; i < N; i++) {
					for (int j = N-2; j >= 0; j--) {
						move(j,i,2);
					}
				}
			} else if(dir.equals("right")){
				for (int i = 0; i < N; i++) {
					for (int j = N-2; j >= 0; j--) {
						move(i,j,3);
					}
				}
			}
			

			sb.append("#"+tc+"\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]+ " ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	public static void move(int i, int j, int d){
		int ni = i + dx[d];
		int nj = j + dy[d];
		if(ni<0||nj<0||ni>=N||nj>=N) return;
		if(visit[ni][nj]) return;
		if(map[i][j] != 0 && map[i][j] == map[ni][nj] && !visit[i][j]){
			map[ni][nj] = map[i][j]*2;
			map[i][j]=0;
			visit[ni][nj] = true;
		} else if(map[ni][nj]==0){
			map[ni][nj] = map[i][j];
			map[i][j] = 0;
		}
		move(ni, nj, d);
	}
	
}
