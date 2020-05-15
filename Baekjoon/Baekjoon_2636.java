package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2636 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		String line = "";
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j*2)-'0';
			}
		}
		int t = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1){
					t++;
				}
			}
		}
		
		int time = 0;
		int modcheese = t;
		while(true){
			//치즈녹이고
			boolean[][] visit = new boolean[N][M];
			Queue<int[]> q = new LinkedList<int[]>();
			visit[0][0] = true;
			q.add(new int[]{0,0,0});
			
			while(!q.isEmpty()){
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int cheesecount = cur[2];
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(visit[nx][ny]) continue;
					if(cheesecount==1) continue;
					
					if(map[nx][ny]==1)
						q.add(new int[]{nx,ny,cheesecount+1});
					else 
						q.add(new int[]{nx,ny,cheesecount});
					visit[nx][ny] = true;
					map[nx][ny] = 0;
				}
			}
			//시간증가
			time++;
			//다녹았는지검사(할때마다 값갱신해서 저장필요)
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1){
						temp++;
					}
				}
			}
			if(temp==0){
				break;
			} else {
				modcheese = temp;
			}
		}
		if(t==0) time=0;
		System.out.println(time);
		System.out.println(modcheese);
	}
}
