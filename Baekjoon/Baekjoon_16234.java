package bak;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_16234 {

	private static int R;
	private static int L;
	private static int N;
	private static int[][] map;
	private static int[][] copy;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		copy = new int[N][N];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
			}
		}
		int ans = 0;
		while(true){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					map[i][j] = copy[i][j];
				}
			}
			int[][] visit = new int[N][N];
			
			int count = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					int sum = map[i][j];
					int avg = 1;
					if(visit[i][j]==0){
						Queue<Pair> q = new LinkedList<>();
						q.offer(new Pair(i,j));
						visit[i][j] = (++count);
						while(!q.isEmpty()){
							Pair cur = q.poll();
							int curx = cur.x;
							int cury = cur.y;
							for(int dir = 0;dir<4;dir++){
								int nx = curx +dx[dir];
								int ny = cury +dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(map[nx][ny]==map[curx][cury]) continue;
								if(Math.abs(map[nx][ny]-map[curx][cury])<L
										||Math.abs(map[nx][ny]-map[curx][cury])>R) continue;
								if(visit[nx][ny]>0) {
									visit[curx][cury] = visit[nx][ny];
									
								}
								else{
									q.offer(new Pair(nx,ny));
									visit[nx][ny] = count;
									sum+=map[nx][ny];
									avg++;
								}
							
							}
						}
//						System.out.println(sum);
//						System.out.println(avg);
						if(avg==1) continue;
						for(int a=0;a<N;a++){
							for(int b=0;b<N;b++){
								if(visit[a][b]==count){
									copy[a][b]=sum/avg;
								}
							}
						}
						
					}//end if
					
				}
			}//end for change visit
			
			
//			for(int i=0;i<N;i++){
//				System.out.println(Arrays.toString(map[i]));
//			}
//			for(int i=0;i<N;i++){
//				System.out.println(Arrays.toString(copy[i]));
//			}
//			for(int i=0;i<N;i++){
//				System.out.println(Arrays.toString(visit[i]));
//			}
//			
//			System.out.println();
			
			int same = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(copy[i][j]==map[i][j]){
						same++;
					}
				}
			}
			if(same==N*N){
				break;
			}
			if(count == 0) {
				break;
			}
			ans++;
			if(ans>2000) break;
		}
		if(ans<=2000)
			System.out.println(ans);
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
