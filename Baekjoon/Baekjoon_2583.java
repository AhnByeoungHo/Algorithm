package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2583 {

	private static int K;
	private static int M;
	private static int N;
	private static int[][] map;
	static int[] dx  ={-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			
			for(int x = startx;x<endx;x++){
				for(int y=starty;y<endy;y++){
					map[y][x] = 1;
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		int[][] visit = new int[N][M];
		int count = 1;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				
				if(visit[i][j]==0&&map[i][j]==0){
					Queue<Pair> q = new LinkedList<>();
					q.offer(new Pair(i,j));
					visit[i][j] = count;
					
					while(!q.isEmpty()){
						Pair cur = q.poll();
						int curx = cur.x;
						int cury = cur.y;
						
						for(int dir=0;dir<4;dir++){
							int nx = curx+dx[dir];
							int ny = cury+dy[dir];
							if(nx<0||ny<0||nx>=N||ny>=M) continue;
							if(visit[nx][ny]!=0||map[nx][ny]==1) continue;
							q.offer(new Pair(nx,ny));
							visit[nx][ny] = count;
						}
					}
					int re=0;
					for(int a=0;a<N;a++){
						for(int b=0;b<M;b++){
							if(visit[a][b]==count){
								re++;
							}
						}
					}
					result.add(re);
					count++;
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+ " ");
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
