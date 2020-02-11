package bak20200211;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 11.
 * @see https://www.acmicpc.net/problem/4485
 * @mem
 * @time
 * @caution DFS Not solved time over
 * 
 * */

public class Baekjoon_4485 {

	static int[][] map;
	private static boolean[][] visit;
	private static int N;
	private static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];

			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j*2)-'0';
				}
			}

			ans = Integer.MAX_VALUE;

			visit = new boolean[N][N];
			visit[0][0] = true;
			visit[0][1] = true;
			dfs(0,1,2,0);

			
			visit = new boolean[N][N];
			visit[0][0] = true;
			visit[1][0] = true;
			dfs(1,0,1,0);
			System.out.println("Problem"+tc+": "+ (ans+map[0][0]+map[N-1][N-1]));
			tc++;
		}
	}
	public static void dfs(int x, int y, int dir, int cnt) {
		//System.out.println(x+" "+y);
		if((x==N-1&&y==N-2)) {
			cnt += map[N-1][N-2];
			if(cnt<ans) 
				ans = cnt;
			return;
		}
		if((x==N-2&&y==N-1)) {
			cnt += map[N-2][N-1];
			if(cnt<ans) 
				ans = cnt;
			return;
		}
		if(x<0||y<0||x>=N||y>=N)
			return;
		else {
			int up= Integer.MAX_VALUE,down= Integer.MAX_VALUE,
					left= Integer.MAX_VALUE,right = Integer.MAX_VALUE;
			if(x>0)
				up = map[x-1][y];
			if(x<N-1)
				down = map[x+1][y];
			if(y>0)
				left = map[x][y-1];
			if(y<N-1)
				right = map[x][y+1];

			if(dir==1) { 		//상에서온것
				int min = Integer.min(down, left);
				min = Integer.min(min,right);

				if(x<N-1) {					//아래로내려가는것 방향 위에서 온거라고 표시
					if(map[x+1][y]==min) {
						if(!visit[x+1][y]) {
							visit[x+1][y] = true;
							dfs(x+1,y,1,cnt+map[x][y]);
							visit[x+1][y] = false;
						}

					}
				}
				if(y>1) {					//왼쪽으로 가는것 오른쪽으로 온거라고 표시
					if(map[x][y-1]==min) {
						if(!visit[x][y-1]) {
							visit[x][y-1] = true;
							dfs(x,y-1,4,cnt+map[x][y]);
							visit[x][y-1] = false;
						}

					}
				}
				if(y<N-1) {					//오른쪽으로가는것 왼쪽에서 온거라고 표시
					if(map[x][y+1]==min) {
						if(!visit[x][y+1]) {
							visit[x][y+1] = true;
							dfs(x,y+1,2,cnt+map[x][y]);
							visit[x][y+1] = false;
						}

					}
				}


			}
			else if(dir==2) {	//왼에서온것
				int min = Integer.min(down, up);
				min = Integer.min(min,right);

				if(x>0) {
					if(map[x-1][y]==min) {	//위로올라가는것 아래에서 온거라고 표시
						if(!visit[x-1][y]) {
							visit[x-1][y] = true;
							dfs(x-1,y,3,cnt+map[x][y]);
							visit[x-1][y] = false;
						}

					}
				}
				if(x<N-1) {					//아래로내려가는것 방향 위에서 온거라고 표시
					if(map[x+1][y]==min) {
						if(!visit[x+1][y]) {
							visit[x+1][y] = true;
							dfs(x+1,y,1,cnt+map[x][y]);
							visit[x+1][y] = false;
						}

					}
				}
				if(y<N-1) {					//오른쪽으로가는것 왼쪽에서 온거라고 표시
					if(map[x][y+1]==min) {
						if(!visit[x][y+1]) {
							visit[x][y+1] = true;
							dfs(x,y+1,2,cnt+map[x][y]);
							visit[x][y+1] = false;
						}

					}
				}
			}
			else if(dir==3) {	//하에서온것
				int min = Integer.min(left, up);
				min = Integer.min(min,right);

				if(y<N-1) {					//오른쪽으로가는것 왼쪽에서 온거라고 표시
					if(map[x][y+1]==min) {
						if(!visit[x][y+1]) {
							visit[x][y+1] = true;
							dfs(x,y+1,2,cnt+map[x][y]);
							visit[x][y+1] = false;
						}

					}
				}
				if(x>0) {
					if(map[x-1][y]==min) {	//위로올라가는것 아래에서 온거라고 표시
						if(!visit[x-1][y]) {
							visit[x-1][y] = true;
							dfs(x-1,y,3,cnt+map[x][y]);
							visit[x-1][y] = false;
						}

					}
				}
				if(y>0) {					//왼쪽으로 가는것 오른쪽으로 온거라고 표시
					if(map[x][y-1]==min) {
						if(!visit[x][y-1]) {
							visit[x][y-1] = true;
							dfs(x,y-1,4,cnt+map[x][y]);
							visit[x][y-1] = false;
						}

					}
				}
			}
			else if(dir==4) {	//오에서온것
				int min = Integer.min(down, up);
				min = Integer.min(min,left);

				if(y>1) {					//왼쪽으로 가는것 오른쪽으로 온거라고 표시
					if(map[x][y-1]==min) {
						if(!visit[x][y-1]) {
							visit[x][y-1] = true;
							dfs(x,y-1,4,cnt+map[x][y]);
							visit[x][y-1] = false;
						}

					}
				}
				if(x>1) {
					if(map[x-1][y]==min) {	//위로올라가는것 아래에서 온거라고 표시
						if(!visit[x-1][y]) {
							visit[x-1][y] = true;
							dfs(x-1,y,3,cnt+map[x][y]);
							visit[x-1][y] = false;
						}

					}
				}
				if(x<N-1) {					//아래로내려가는것 방향 위에서 온거라고 표시
					if(map[x+1][y]==min) {
						if(!visit[x+1][y]) {
							visit[x+1][y] = true;
							dfs(x+1,y,1,cnt+map[x][y]);
							visit[x+1][y] = false;
						}

					}
				}

			}
		}
	}

}
