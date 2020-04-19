package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_18809 {
	private static int rNum;
	private static int gNum;
	private static int M;
	private static int N;
	private static int[][] map;
	private static int[][] gvisit;
	private static int[][] rvisit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = Integer.MIN_VALUE;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gNum = Integer.parseInt(st.nextToken());
		rNum = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rvisit = new int[N][M];
		gvisit = new int[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2){
					list.add(new int[]{i,j});
				}
			}
		}

		combi(0, 0, new int[gNum+rNum][2], gNum+rNum, new int[gNum+rNum],0,0);
		System.out.println(ans);
	}
	public static void combi(int depth, int start, int[][] output, 
			int tdepth, int[] gorr, int gcount, int rcount){
		if(gcount>gNum || rcount>rNum) return;
		if(depth==tdepth){

			rvisit = new int[N][M];
			gvisit = new int[N][M];
			for(int i=0;i<depth;i++){
				if(gorr[i]==1){
					rvisit[output[i][0]][output[i][1]] = 1;
				}
				else if(gorr[i] == 0){
					gvisit[output[i][0]][output[i][1]] = 1;
				}
			}
			bfs();
			return;
		}

		for(int i=start;i<list.size();i++){

			output[depth][0] = list.get(i)[0];
			output[depth][1] = list.get(i)[1];
			gorr[depth] = 0;
			combi(depth+1, i+1, output, tdepth, gorr, gcount+1, rcount);
			gorr[depth] = 1;
			combi(depth+1, i+1, output, tdepth, gorr, gcount, rcount+1);
		}

	}
	private static void bfs() {
		Queue<int[]> q  =new LinkedList<>();
		boolean[][] flower = new boolean[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(rvisit[i][j]==1)
					q.add(new int[]{i,j,1});
				if(gvisit[i][j]==1)
					q.add(new int[]{i,j,0});
			}
		}
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curx = cur[0];
			int cury = cur[1];
			int color = cur[2];

			if(flower[curx][cury]) continue;
			for(int dir=0;dir<4;dir++){
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(map[nx][ny]==0) continue;
				if(flower[nx][ny]) continue;
				if(color==0 && (rvisit[nx][ny]!=gvisit[curx][cury]) && gvisit[nx][ny]!=0) continue;
				if(color==1 && (gvisit[nx][ny]!=rvisit[curx][cury])&& rvisit[nx][ny]!=0) continue;
				
				if(color==0){
					if(rvisit[nx][ny]!=0 && (rvisit[nx][ny]==gvisit[curx][cury]+1)){
						flower[nx][ny] = true;
					} else if(gvisit[nx][ny]==0){
						q.add(new int[]{nx,ny,0});
						gvisit[nx][ny] = gvisit[curx][cury]+1;
					}

				}else if(color==1){
					if(gvisit[nx][ny]!=0 && (gvisit[nx][ny]==rvisit[curx][cury]+1)){
						flower [nx][ny] = true;
					} else if(rvisit[nx][ny]==0){
						q.add(new int[]{nx,ny,1});
						rvisit[nx][ny] = rvisit[curx][cury]+1;
					}
				}
			}

		}
		int f = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(flower[i][j]){
					f++;
				}
			}
		}
		ans = Integer.max(ans, f);
	}
}
