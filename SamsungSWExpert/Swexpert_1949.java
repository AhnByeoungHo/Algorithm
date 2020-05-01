package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swexpert_1949 {
	private static int K;
	private static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	private static int[][] copy;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			ans = Integer.MIN_VALUE;
			int highest = 0;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					highest = Math.max(map[i][j], highest);
				}
			}
			for (int temp = K; temp >= 1; temp--) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map.length; j++) {
						copy = new int[N][N];
						ArrayList<int[]> high = new ArrayList<>();
						for (int k = 0; k < copy.length; k++) {
							for (int k2 = 0; k2 < copy.length; k2++) {
								copy[k][k2] = map[k][k2];
								if(copy[k][k2]==highest){
									high.add(new int[]{k,k2});
								}
							}
						}
						copy[i][j] = copy[i][j]-temp;
						for (int k = 0; k < high.size(); k++) {
							dfs(high.get(k)[0],high.get(k)[1],1);
						}
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int i, int j, int cost) {
		
		for (int dir = 0; dir < 4; dir++) {
			int nx = i + dx[dir];
			int ny = j + dy[dir];
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(copy[nx][ny]>=copy[i][j]) continue;
			dfs(nx, ny, cost+1);
		}
		ans = Math.max(ans, cost);
	}
}
