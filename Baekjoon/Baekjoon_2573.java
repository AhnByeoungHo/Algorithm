package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2573 {

	private static int M;
	private static int N;
	private static int[][] map;
	private static int[][] copy;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int time = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}

		while(true){
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					map[i][j] = copy[i][j];
				}
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]!=0){
						int count = 0;
						for(int dir=0;dir<4;dir++){
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							if(nx<0||ny<0||nx>=N||ny>=M) continue;
							if(map[nx][ny]!=0) continue;
							count++;
						}
						copy[i][j] = map[i][j] - count;
						if(copy[i][j]<0) copy[i][j] = 0;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(copy[i]));
//			}
//			System.out.println("-----");
			time ++;
			Queue<Pair> q = new LinkedList<>();
			boolean[][] visit = new boolean[N][M];
			int bigC = 0;
			for(int i=0;i<N;i++){
				for (int j = 0; j < M; j++) {
					if(copy[i][j]!=0&&!visit[i][j]){
						bigC++;
						if(bigC>=2) {
							System.out.println(time);
							System.exit(0);
						}
						q.offer(new Pair(i,j));
						visit[i][j] = true;
						while(!q.isEmpty()){
							int curx = q.peek().x;
							int cury = q.peek().y;
							q.poll();
							for(int dir=0;dir<4;dir++){
								int nx = curx + dx[dir];
								int ny = cury + dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=M) continue;
								if(copy[nx][ny]==0||visit[nx][ny]) continue;
								q.offer(new Pair(nx,ny));
								visit[nx][ny] = true;
							}
						}
					}
				}
			}
			int s = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					s+=copy[i][j];
				}
			}
			if(s==0){
				System.out.println(0);
				System.exit(0);
			}

		}


	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
