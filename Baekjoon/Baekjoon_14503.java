package bak20200220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_14503 {

	private static int M;
	private static int N;
	private static int[][] map;
	private static Robot startrobot;

	static int[] dx = {-1,0,1,0};//0위1오2아3왼
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		startrobot = new Robot(x, y, dir);

		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j*2)-'0';
			}
		}

		int count = 4;
		int dircount = 0;
		
		while(true) {
			int curx = startrobot.x;
			int cury = startrobot.y;
			int curdir = startrobot.dir;
			//System.out.println(startrobot + " c:" + dircount);
			if(map[curx][cury]==0) {
				map[curx][cury] = count++;
			}
			int ndir = (4+curdir-1)%4;
			int nx = curx +dx[ndir];
			int ny = cury + dy[ndir];

			if(map[nx][ny]==0) {
				startrobot.dir = ndir;
				startrobot.x = nx;
				startrobot.y = ny;
				dircount = 0;
			}
			else {
				startrobot.dir = ndir;
				dircount++;
			}
			if(dircount==4) {
				int nd = (curdir+1)%4;
				if(map[curx+dx[nd]][cury+dy[nd]]!=1) {
					startrobot.x = curx+dx[nd];
					startrobot.y = cury+dy[nd];
					dircount = 0;
				}
				else {
//					for(int i=0;i<N;i++) {
//						System.out.println(Arrays.toString(map[i]));
//					}
					break;
				}

			}
			
		}
		System.out.println(count-4);
	}
	static class Robot{
		int x;
		int y;
		int dir;//0위1오2아3왼
		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return x + "," + y + ":" + dir;
		}

	}

}
