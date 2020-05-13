package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_15683 {
	private static int M;
	private static int N;
	private static int[][] map;
	private static int cctvNum;
	private static ArrayList<Pair> cctvlist;
	//상우하좌 0123
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int[][] copy;
	private static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvlist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j*2)-'0';
				if(map[i][j]>=1 && map[i][j]<=5) {
					cctvlist.add(new Pair(i, j));
				}
			}
		}
		cctvNum = cctvlist.size();
		ans = Integer.MAX_VALUE;
		copy = new int [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		permute(0, new int[cctvNum]);
		System.out.println(ans);
	}
	static void permute(int depth, int[] dirlist){
		if(depth==cctvNum){
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy[i][j] == 0) count++;
				}
			}
			ans = Math.min(ans, count);
			return;
		}
		for (int dir = 0; dir < 4; dir++) {
			dirlist[depth] = dir;
			int cn = map[cctvlist.get(depth).x][cctvlist.get(depth).y];
			int curx = cctvlist.get(depth).x;
			int cury = cctvlist.get(depth).y;
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = copy[i][j];
				}
			}
			if(cn==1){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[dir];
					ny = ny + dy[dir];
				}		
			} else if(cn==2){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[dir];
					ny = ny + dy[dir];
				}
				nx = curx + dx[(dir+2)%4];
				ny = cury + dy[(dir+2)%4];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[(dir+2)%4];
					ny = ny + dy[(dir+2)%4];
				}
			} else if(cn==3){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[dir];
					ny = ny + dy[dir];

				}
				nx = curx + dx[(dir+1)%4];
				ny = cury + dy[(dir+1)%4];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[(dir+1)%4];
					ny = ny + dy[(dir+1)%4];
				}
			} else if(cn==4){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[dir];
					ny = ny + dy[dir];
				}
				nx = curx + dx[(dir+1)%4];
				ny = cury + dy[(dir+1)%4];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[(dir+1)%4];
					ny = ny + dy[(dir+1)%4];
				}
				nx = curx + dx[(dir+3)%4];
				ny = cury + dy[(dir+3)%4];
				while(true){
					if(nx<0||ny<0||nx>=N||ny>=M) break;
					if(map[nx][ny]==6) break;
					copy[nx][ny] = -1;
					nx = nx + dx[(dir+3)%4];
					ny = ny + dy[(dir+3)%4];
				}

			} else if(cn==5){
				for (int i = 0; i < 4; i++) {
					int nx = curx + dx[i];
					int ny = cury + dy[i];
					while(true){
						if(nx<0||ny<0||nx>=N||ny>=M) break;
						if(map[nx][ny]==6) break;
						copy[nx][ny] = -1;
						nx = nx + dx[i];
						ny = ny + dy[i];
					}
				}
			}
			permute(depth+1, dirlist);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = temp[i][j];
				}
			}
		}
	}
}
class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
