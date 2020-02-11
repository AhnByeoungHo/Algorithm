package bak20200211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2667 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	private static int N;
	private static int[][] map;
	private static int[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		visit = new int[N][N];
		int count = 1;
		Queue<Pair> q= new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]==0&&map[i][j]==1) {
					q.offer(new Pair(i,j));
					visit[i][j] = count;
					while(!q.isEmpty()) {
						int curx = q.peek().x;
						int cury = q.peek().y;
						q.poll();
						if(map[curx][cury]!=0) {
							for(int dir=0;dir<4;dir++) {
								int nx = curx +dx[dir];
								int ny = cury +dy[dir];
								
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(map[nx][ny]==0 || visit[nx][ny]!=0) continue;
								
								q.offer(new Pair(nx,ny));
								visit[nx][ny] = count;
							}
						}
					}
					count++;
				}
			}
		}
//		for(int i=0;i<N;i++)
//			System.out.println(Arrays.toString(visit[i]));
		System.out.println(count-1);
		int[] result = new int[count-1];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]!=0) {
					result[visit[i][j]-1]++;
				}
			}
		}
		
		Arrays.sort(result);
		for(int i=0;i<count-1;i++)
			System.out.println(result[i]);
		
		
	}
	static class Pair{
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
