package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedTransferQueue;

public class Baekjoon_17244 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] map = new char [N][M];
		int[] start = new int[2];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='S'){
					start[0] = i;
					start[1] = j;
					map[i][j] = '.';
				} else if(map[i][j]=='X'){
					map[i][j] = (char) ('A'+ cnt);
					cnt++;
				} else if(map[i][j]=='E'){
					map[i][j] = 'Z';
				}
			}
		}
		
		boolean[][][] visit = new boolean[1<<cnt][N][M];
		Queue<int[]> q = new LinkedTransferQueue<int[]>();
		visit[0][start[0]][start[1]] = true;
		
		q.add(new int[]{start[0],start[1],0,0});
		int ans = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curx = cur[0];
			int cury = cur[1];
			int curkey = cur[2];
			int curt = cur[3];
			if(map[curx][cury]=='Z' && curkey==((1<<cnt)-1)) {
				ans = curt;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(map[nx][ny]=='#')continue;
				if(visit[curkey][nx][ny])continue;
				if(map[nx][ny]=='.'){
					visit[curkey][nx][ny] = true;
					q.add(new int[]{nx,ny,curkey,curt+1});
				}
				if(map[nx][ny]>='A' && map[nx][ny]<='E'){
					int key = curkey | 1<<map[nx][ny]-'A';
					if(!visit[key][nx][ny]){
						visit[key][nx][ny] = true;
						q.add(new int[]{nx,ny,key,curt+1});
					}
				} else if(map[nx][ny]=='Z'){
					if(!visit[curkey][nx][ny]){
						visit[curkey][nx][ny] = true;
						q.add(new int[]{nx,ny,curkey,curt+1});
					}
				}
				
			}
		}
		System.out.println(ans);
		
	}
}
