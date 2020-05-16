package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_5650 {
	//상우하좌 0123
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] block = {{2,3,0,1},{2,3,1,0},{1,3,0,2},{3,2,0,1},{2,0,3,1},{2,3,0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];

			boolean[] check = new boolean[5];
			int[][] hell = new int[5][4];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 5) {
						int value = map[i][j] - 6;
						if(check[value]) {
							hell[value][2]=i;
							hell[value][3]=j;
						}else {
							check[value] = true;
							hell[value][0]=i;
							hell[value][1]=j;

						}
					}
				}
			}

			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==0){
						int sx = i;
						int sy = j;
						int ijcost = Integer.MIN_VALUE;
						//move
						for (int dir = 0; dir < 4; dir++) {
							int dircost = 0;
							int curx = sx;
							int cury = sy;
							int curdir = dir;
							while(true){
								int nx = curx + dx[curdir];
								int ny = cury + dy[curdir];
								if(nx==sx && ny==sy) break;
								if(nx <0 || ny <0 || nx>=N || ny >= N){
									curdir = block[0][curdir];
									curx = nx;
									cury = ny;
									dircost++;
									continue;
								}
								if(map[nx][ny]==0){
									curx = nx;
									cury = ny;
									continue;
								}
								if(map[nx][ny]==-1){
									break;
								}

								else if(map[nx][ny]>=1 && map[nx][ny]<=5){//block
									curx = nx;
									cury = ny;
									curdir = block[map[nx][ny]][curdir];
									dircost++;
									continue;
								}
								else if(map[nx][ny]>=6 && map[nx][ny]<=10){//warmhole
									int value = map[nx][ny]-6;
									if(nx == hell[value][0] && ny == hell[value][1]) {
										curx = hell[value][2];
										cury = hell[value][3];
									}else if(nx == hell[value][2] && ny == hell[value][3]) {
										curx = hell[value][0];
										cury = hell[value][1];
									}
								}
							}
							ijcost = Math.max(ijcost, dircost);
						}
						ans = Math.max(ans, ijcost);
					}
				}
			}
			System.out.println("#"+tc+" " +ans);
		}
	}
}
