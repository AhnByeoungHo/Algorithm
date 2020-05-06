package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2146 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j*2)-'0';
			}
		}
		
		int[][] visit = new int[N][N];
		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && visit[i][j]==0){
					Queue<int[]> q = new LinkedList<>();
					visit[i][j] = count;
					q.add(new int[]{i,j});
					
					while(!q.isEmpty()){
						int[] cur = q.poll();
						int curx = cur[0];
						int cury = cur[1];
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = curx + dx[dir];
							int ny = cury + dy[dir];
							if(nx<0||ny<0||nx>=N||ny>=N) continue;
							if(map[nx][ny] == 0 || visit[nx][ny] !=0 ) continue;
							
							q.add(new int[]{nx,ny});
							visit[nx][ny] = count;
						}
					}
					count++;
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int c = 1; c <= count; c++) {
			Queue<int[]> q = new LinkedList<>();
			boolean[][] v = new boolean[N][N];
			for (int i = 0; i < visit.length; i++) {
				for (int j = 0; j < visit.length; j++) {
					if(visit[i][j]==c){
						q.add(new int[]{i,j,visit[i][j],0});
						v[i][j] = true;
					}	
				}
			}
			
			while(!q.isEmpty()){
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int curid = cur[2];
				int cost = cur[3];
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(visit[nx][ny]==curid) continue;
					if(visit[nx][ny]!=curid && visit[nx][ny]!=0){
						ans = Math.min(ans, cost);
					}
					if(visit[nx][ny]==0){
						if(v[nx][ny]) continue;
						else{
							q.add(new int[]{nx,ny,curid,cost+1});
							v[nx][ny] = true;
						}	
					}
				}
			}
		}
		System.out.println(ans);	
	}
}
