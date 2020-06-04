package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5427 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][M];
			int[] start = new int[3];
			Queue<int[]> fire = new LinkedList<>();
			boolean[][] fvisit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j]=='@'){
						start[0] = i;
						start[1] = j;
					}if(map[i][j]=='*'){
						fire.add(new int[]{i,j});
						fvisit[i][j] = true;
					}
				}
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][] visit = new boolean[N][M];
			q.add(start);
			visit[start[0]][start[1]] = true;
			int time = 0;
			int ans = 0;
			while(!q.isEmpty()){
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int curt = cur[2];
				//System.out.println(Arrays.toString(cur));
				
				if(curx==0||cury==0||curx==N-1||cury==M-1) {
					ans = curt+1;
					break;
				}
				if(curt==time){
					//화재번짐
					int size = fire.size();
					while(size!=0){
						int[] curf = fire.poll();
						int curfx = curf[0];
						int curfy = curf[1];
						for (int dir = 0; dir < 4; dir++) {
							int nx = curfx + dx[dir];
							int ny = curfy + dy[dir];
							if(nx<0||ny<0||nx>=N||ny>=M) continue;
							if(fvisit[nx][ny]) continue;
							if(map[nx][ny]=='#'||map[nx][ny]=='*') continue;
							map[nx][ny]='*';
							fvisit[nx][ny] = true;
							fire.add(new int[]{nx,ny});
						}
						size--;
					}
					time++;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(visit[nx][ny]) continue;
					if(map[nx][ny]=='#'||map[nx][ny]=='*') continue;
					q.add(new int[]{nx,ny,curt+1});
					visit[nx][ny] = true;
				}
			}
			if(ans==0){
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(ans);
			}
			
		}
		
		
	}
}
