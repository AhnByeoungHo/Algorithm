package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swexpert_5656 {
	private static int N;
	private static int H;
	private static int W;
	private static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans;
	private static int allblock;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			allblock = 0;
			for (int i = 0; i <H ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) allblock++;
				}
			}
			//N개선택(중복가능)
			ans = Integer.MAX_VALUE;
			permute(0, new int[N]);
			System.out.println("#"+tc+" "+ans);
		}

	}

	public static void permute(int depth,int[] output) {
		if(depth==N){
			ans = Math.min(ans, solve(output));
			return;
		}
		for (int i = 0; i < W; i++) {
			output[depth] = i;
			permute(depth+1, output);
		}
	}
	public static int solve(int[] order){
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			int curx = 0;
			int cury = order[i];
			while(true){
				if(curx>=H) {
					//return 0;
					break;
				}
				if(copy[curx][cury]==0){
					curx++;
					continue;
				}
				else {
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[]{curx, cury,copy[curx][cury]});
					copy[curx][cury] = 0;

					while(!q.isEmpty()){

						int[] cur = q.poll();
						

						int weight = cur[2];
						
							for (int dir = 0; dir < 4; dir++) {
								int cx = cur[0];
								int cy = cur[1];
								for (int w = 0; w < weight-1; w++) {
								int nx = cx + dx[dir];
								int ny = cy + dy[dir];
								if(nx<0||ny<0||nx>=H||ny>=W) continue;
								if(copy[nx][ny]==0) {
									cx = nx;
									cy = ny;
									continue;
								
								}
								q.add(new int[]{nx,ny,copy[nx][ny]});
								copy[nx][ny] = 0;
								cx = nx;
								cy = ny;
							}
						}
						
					}
					//down
					int[][] temp = new int[H][W];
					for (int a = 0; a < W; a++) {
						int idx = H-1;
						for (int b = H-1; b >= 0; b--) {
							if(copy[b][a]!=0){
								temp[idx][a] = copy[b][a];
								idx--;
							}
						}
					}
					
					for (int a = 0; a < H; a++) {
						for (int b = 0; b < W; b++) {
							copy[a][b] = 0;
							copy[a][b] = temp[a][b];
						}
					}
					break;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(copy[i][j]!=0) count++;
			}
		}

		return count;
	}
}
