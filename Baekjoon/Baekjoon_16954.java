package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_16954 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1,0};
	static int[] dy = {0,1,1,1,0,-1,-1,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][][] visit = new boolean[8][8][8];
		q.add(new int[]{0,7,0});
		visit[0][7][0] = true;
		
		int start = 1;
		int ans = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curt = cur[0];
			int curx = cur[1];
			int cury = cur[2];
			if(curx==0&&cury==7){
				ans = 1;
				break;
			}
			if(curt>=8){
				ans = 1;
				break;
			}
			if(curt==start){
				char[][] temp = new char[8][8];
				Arrays.fill(temp[0], '.');
				for (int i = 1; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						temp[i][j] = map[i-1][j];
					}
				}
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						map[i][j] = temp[i][j];
					}
				}
				//down
				start++;
			}
			if(map[curx][cury]=='#') continue;
			for (int dir = 0; dir < 9; dir++) {
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=8||ny>=8) continue;
				//if(visit[curt][nx][ny]) continue;
				if(map[nx][ny]=='#') continue;
				if(curt<7){
					q.add(new int[]{curt+1,nx,ny});
					visit[curt+1][nx][ny] = true;
				} else {
					q.add(new int[]{7,nx,ny});
					visit[7][nx][ny] = true;
				}
				
			}
		}
		System.out.println(ans);
	}
}
