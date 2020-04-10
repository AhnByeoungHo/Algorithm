package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Baekjoon_4485 {

	private static int[][] map;
	private static int N;
	private static int ans;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true){
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			for(int i=0;i<N;i++){
				String str = br.readLine();
				for(int j=0;j<N;j++){
					map[i][j] = str.charAt(j*2)-'0';
				}
			}
			ans = 0;
			int[][] D = new int[N][N];
			for(int i=0;i<N;i++)
				Arrays.fill(D[i], Integer.MAX_VALUE);
			boolean[][] check = new boolean[N][N];

			//dijkstra 시작점이 a정점이라면 D[a] = 0
			D[0][0] = map[0][0];
			for(int i = 0; i < N; i++) {
				for( int j = 0; j < N; j++ ) {
					int min = Integer.MAX_VALUE;//가장 작은 값을 기억할 변수
					int curx = -1; //그 위치를 기억할 변수
					int cury = -1;
					//아직 처리하지 않았으면서, 가장 짧은 거리라면
					for (int x = 0; x < N; x++) {
						for (int k = 0; k < N; k++) {
							if(!check[x][k] && min >= D[x][k]) {
								min = D[x][k];
								curx = x;
								cury = k;
							}
						}
					}
					
					//연결이 없는 경우 끝.
					if(curx == -1 || cury == -1)
						break;

					for(int dir=0;dir<4;dir++){
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0||nx>=N||ny>=N) continue;
						//if(check[nx][ny]) continue;
						 
						if((D[curx][cury] + map[nx][ny])>D[nx][ny]) continue;
						
						D[nx][ny] = D[curx][cury] + map[nx][ny];
					}
					check[curx][cury] = true;

				}
			}	
			System.out.println("Problem "+(tc++)+": " +D[N-1][N-1]);
		}
	}
}
