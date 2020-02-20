package bak20200220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17142 {

	private static int N;
	private static int r;
	private static int[][] map;
	private static ArrayList<int[]> vList;
	private static Queue<int[]> q;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		vList = new ArrayList<>();
		q = new LinkedList<>();
		
		for(int i=0;i<N;i++){
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = line.charAt(j*2)-'0';
				if(map[i][j]==2)
					vList.add(new int[] {i,j});
			}
		}

		int[] output = new int[r];
		per(0, output, 0);
		if(MIN==Integer.MAX_VALUE) MIN = -1;
		System.out.println(MIN);		
	}
	public static void per(int depth, int[] output, int start) {
		if(depth==r) {
			q.clear();
			int[] temp = new int[output.length];
			for(int i=0;i<output.length;i++) {
				temp[i] = output[i];
			}
			bfs(output);
			return;
		}
		else {
			for(int i=start;i<vList.size();i++) {
				output[depth] = i;
				per(depth+1, output, i+1);
			}
		}
	}
	private static void bfs(int[] per) {
		int[][] visit = new int[N][N];
		for(int i=0;i<per.length;i++) {
			q.offer(vList.get(per[i]));
			visit[vList.get(per[i])[0]][vList.get(per[i])[1]] = 1;
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curx = cur[0];
			int cury = cur[1];
			for(int dir = 0;dir<4;dir++) {
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(map[nx][ny]==1) continue;
				if(visit[nx][ny]>0) continue;
				
				q.offer(new int[] {nx,ny});
				visit[nx][ny] = visit[curx][cury]+1;	
			}
		}
		int result=0;
		boolean zero=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=1) {
					if(visit[i][j]==0) {
						zero = true;
						break;
					}
					else if(map[i][j]!=2){
						result = Math.max(result, visit[i][j]);
					}
				}
			}
			if(zero) break;
		}
//		for (int i = 0; i < visit.length; i++) {
//			for (int j = 0; j < visit.length; j++) {
//				System.out.print(visit[i][j]);
//			}
//			System.out.println();
//		}
		if(zero) return;
		else {
			if(result==0) {
				MIN = Math.min(0, MIN);
			}
			else {
				MIN = Math.min(result-1, MIN);
			}
		}
	}
}
