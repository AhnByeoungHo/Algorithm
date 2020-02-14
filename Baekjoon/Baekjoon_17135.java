package bak20200214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_17135 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static ArrayList<int[]> comList;
	private static int[][] visit;
	private static int D;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1};
	private static int s=-1;
	static int max = Integer.MIN_VALUE;
	private static int[][] copy;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		copy = new int[N][M];
		comList = new ArrayList<>();

		ArrayList<Pair> enemy = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
				if(map[i][j]==1)
					enemy.add(new Pair(i,j,true));
			}
		}
		
		int[] output = new int[3];
		combi(0,3,output,0);


		for(int i=0;i<comList.size();i++) {
			System.out.println(Arrays.toString(comList.get(i)));
			Pair first = new Pair(N-1,(comList.get(i)[0]),true);
			Pair second = new Pair(N-1,(comList.get(i)[1]),true);
			Pair third = new Pair(N-1,(comList.get(i)[2]),true);
			for(int a=0;a<enemy.size();a++) {
				enemy.get(a).life = true;
			}
			for(int a=0;a<N;a++) {
				for(int b=0;b<M;b++) {
					map[a][b]=copy[a][b];
				}
			}
			
			int time = 0;
			int out=0;
			while(true) {
				
				Queue<Pair> q = new LinkedList<>();
				q.add(first);
				visit = new int[N][M];
				visit[first.x][first.y] = 1;
				while(!q.isEmpty()) {
					Pair cur = q.poll();
					int curx = cur.x;
					int cury = cur.y;
					if(map[curx][cury]==1 && visit[curx][cury]<= D) {
						for(int p=0;p<enemy.size();p++) {
							if(enemy.get(p).x+time==curx && enemy.get(p).y==cury) {
								enemy.get(p).life = false;
								break;
							}
						}
						break;
					}

					for(int dir=0;dir<3;dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0|ny>=M) continue;
						if(visit[nx][ny]!=0) continue;
						
						q.offer(new Pair(nx,ny,true));
						visit[nx][ny] = visit[curx][cury]+1;
						if(map[nx][ny]==1) break;

					}
				}
				q.clear();

				
				q.add(second);
				visit = new int[N][M];
				visit[second.x][second.y] = 1;
				while(!q.isEmpty()) {
					Pair cur = q.poll();
					int curx = cur.x;
					int cury = cur.y;

					if(map[curx][cury]==1&& visit[curx][cury]<= D) {
						for(int p=0;p<enemy.size();p++) {
							if(enemy.get(p).x+time==curx && enemy.get(p).y==cury) {
								enemy.get(p).life = false;
								break;
							}
						}
						break;
					}

					for(int dir=0;dir<3;dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0|ny>=M) continue;
						if(visit[nx][ny]!=0) continue;
						q.offer(new Pair(nx,ny,true));
						visit[nx][ny] = visit[curx][cury]+1;
						if(map[nx][ny]==1) break;

					}
				}
				q.clear();
				
				
				q.add(third);
				visit = new int[N][M];
				visit[third.x][third.y] = 1;
				while(!q.isEmpty()) {
					Pair cur = q.poll();
					int curx = cur.x;
					int cury = cur.y;

					if(map[curx][cury]==1&& visit[curx][cury]<= D) {
						for(int p=0;p<enemy.size();p++) {
							if(enemy.get(p).x+time==curx && enemy.get(p).y==cury) {
								enemy.get(p).life = false;
								break;
							}
						}
						break;
					}

					for(int dir=0;dir<3;dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0|ny>=M) continue;
						if(visit[nx][ny]!=0) continue;
						q.offer(new Pair(nx,ny,true));
						visit[nx][ny] = visit[curx][cury]+1;
						if(map[nx][ny]==1) break;

					}
				}
				
				for(int a=0;a<N;a++) {
					for(int b=0;b<M;b++) {
						map[a][b]=0;
					}
				}
				time++;
				
				for(int a=0;a<enemy.size();a++) {
					if(enemy.get(a).life&&enemy.get(a).x+time<N) {
						map[enemy.get(a).x+time][enemy.get(a).y]=1;
					}
				}
				
				for(int a=0;a<enemy.size();a++) {
					if(enemy.get(a).x+time>=N&&enemy.get(a).life) {
						enemy.get(a).life = false;
						out++;
					}
				}

				s = 0;
				for(int a=0;a<N;a++) {
					for(int b=0;b<M;b++) {
						s+=map[a][b];
					}
				}

				if(s==0){
					int ans = 0;
					for(int a=0;a<enemy.size();a++) {
						if(!enemy.get(a).life) {
							ans++;
						}
					}
					System.out.println(ans-out);
					if(max<ans-out) max = ans-out; 
					break;
				}
				
			}
			
		}
		System.out.println(max);

	}

	private static void combi(int depth, int r, int[] output, int start) {
		if(depth==r) {
			int[] temp = new int[3];
			for(int i=0;i<3;i++) temp[i]=output[i];
			comList.add(temp);

			return;

		}
		else {
			for(int i=start;i<M;i++) {
				output[depth] = i;
				combi(depth+1, r, output, i+1);
			}
		}
	}

	static class Pair{
		int x;
		int y;
		boolean life;
		Pair(int x, int y, boolean life){
			this.x=x;
			this.y=y;
			this.life=life;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+","+y+" :"+life;
		}
	}
}
