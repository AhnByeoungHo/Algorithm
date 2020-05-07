package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_16236 {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] sea = new int[N][N];
		Shark baby = null;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				sea[i][j] = line.charAt(j*2)-'0';
				if(sea[i][j]==9){
					baby = new Shark(i,j,2,0,0);
					sea[i][j] = 0;
				}
			}
		}
		
		
		while(true){
			boolean iseat = false;
			if(baby.eatcount==baby.w){
				baby.w = baby.w+1;
				baby.eatcount = 0;
			}
			Queue<Shark> q = new LinkedList<Shark>();
			q.add(baby);
			boolean[][] visit = new boolean[N][N];
			visit[baby.x][baby.y] = true;
			
			boolean end = false;
			int mindis = Integer.MAX_VALUE;
			while(!q.isEmpty()){
				Shark cur = q.poll();
				
				int curx =  cur.x;
				int cury = cur.y;
				int curw = cur.w;
				int cureat = cur.eatcount;
				int curmove = cur.move;
				if(curmove>mindis){
					for (int i = 0; i < visit.length; i++) {
						for (int j = 0; j < visit.length; j++) {
							if(visit[i][j] && baby.w>sea[i][j]&&sea[i][j]!=0){
								baby = new Shark(i, j, curw, cureat+1, curmove);
								sea[i][j] = 0;
								iseat = true;
								end = true;
								//System.out.println(i+" "+j + " "+curw+ " "+ curmove);
								break;
							}
						}
						if(end) break;
					}
				}
				if(end) {
					q.clear();
					break;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(visit[nx][ny]) continue;
					if(curw < sea[nx][ny] && sea[nx][ny]!=0) continue;
					if(sea[nx][ny]==0 || curw == sea[nx][ny]){
						q.add(new Shark(nx, ny, curw, cureat, curmove+1));
						visit[nx][ny] = true;
					}
					if(curw>sea[nx][ny] && sea[nx][ny]!=0){
						//baby = new Shark(nx, ny, curw, cureat+1, curmove+1);
						//sea[nx][ny] = 0;
						visit[nx][ny] = true;
						q.add(new Shark(nx, ny, curw, cureat, curmove+1));
						//end = true;
						iseat = true;
						if(mindis > curmove) mindis = curmove;
						//break;
					}
				}
				//if(end) break;
				
			}
			//System.out.println(baby.w + " " +baby.eatcount + "("+baby.x+","+baby.y+")");
			for (int j = 0; j < N; j++) {
				//System.out.println(Arrays.toString(sea[j]));
			}
			//System.out.println("-----------");
			if(!iseat) break;
		}
		System.out.println(baby.move);
	}
	static class Shark{
		int x;
		int y;
		int w;
		int eatcount;
		int move;
		public Shark(int x, int y, int w, int eatcount, int move) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.eatcount = eatcount;
			this.move = move;
		}
	}
}
