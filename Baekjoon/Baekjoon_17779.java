package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17779 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int d1 = 0; d1<=N-i && d1 <= N-j; d1++) {
					if(j-d1<0) continue;
					for (int d2 = 0; d2 <= N-i && d2 <= N-j; d2++) {
						if( i+d1+d2>=N)break;
						if( j-d1+d2>N || j-d1+d2<0||j+d2>=N) continue;
						int[][] space = new int[N][N];
						for (int a = 0; a < d1; a++) {
							space[i+a][j-a] = 5;
							space[i+d2+a][j+d2-a] = 5;
						}
						for (int a = 0; a < d2; a++) {
							space[i+a][j+a] = 5;
							space[i+d1+a][j-d1+a] = 5;
						}
						space[i+d1+d2][j-d1+d2] = 5;
						boolean[][] visit = new boolean[N][N];
						int[] start = new int[2];
				loop:	for (int a = 1; a < space.length; a++) {
							for (int b = 1; b < N-1; b++) {
								if(space[a-1][b]==5 && space[a][b-1]==5 && space[a][b+1]==5){
									visit[a][b] = true;
									start[0] = a;
									start[1] = b;
									space[a][b] = 5;
									break loop;
								}
							}
						}
						Queue<int[]> q = new LinkedList<int[]>();
						q.add(start);
						
						while(!q.isEmpty()){
							int[] cur = q.poll();
							int curx = cur[0];
							int cury=cur[1];
							for (int dir = 0; dir < 4; dir++) {
								int nx = curx + dx[dir];
								int ny = cury + dy[dir];
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								if(space[nx][ny]==5) continue;
								if(visit[nx][ny]) continue;
								q.add(new int[]{nx,ny});
								visit[nx][ny] = true;
								space[nx][ny] = 5;
							}
						}
						
						boolean[] sectornum = new boolean[5];
						sectornum[4] = true;
						for (int a = 0; a < space.length; a++) {
							for (int b = 0; b < space.length; b++) {
								if(space[a][b]==5)continue;
								if(a>=0 && a<i+d1 && b<=j) {
									space[a][b] = 1;
									sectornum[0] = true;
								}
								else if(a>=0&&a<=i+d2 &&b>j&&b<N) {
									space[a][b]=2;
									sectornum[1] = true;
								}
								else if(a>=i+d1 && a<N && b>=0 && b<j-d1+d2) {
									space[a][b]=3;
									sectornum[2] = true;
								}
								else if(a>i+d2 && a<N && b>=j-d1+d2 && b<N) {
									space[a][b]=4;
									sectornum[3] = true;
								}
							}
						}
						for (int a = 1; a < N-1; a++) {
							for (int b = 1; b < N-1; b++) {
								if(space[a-1][b]==5 && space[a][b-1]==5
										&& space[a+1][b]==5 && space[a][b+1]==5){
									space[a][b]=5;
								}
							}
						}
						boolean isok = true;
						for (int k = 0; k < sectornum.length; k++) {
							isok &= sectornum[k];
						}
						if(isok){
							int[] people = new int[5];
							for (int a = 0; a < N; a++) {
								for (int b = 0; b < N; b++) {
									people[space[a][b]-1] += map[a][b];
								}
							}
							Arrays.sort(people);
							int abs = people[4]-people[0];
							/*if(abs<ans){
								System.out.println(i+" "+j+" "+d1+ " "+d2);
								System.out.println(Arrays.toString(people));
								if(i==1&&j==2 &&d2==2&&d1==1){
									for (int k = 0; k < N; k++) {
										System.out.println(Arrays.toString(space[k]));
									}
								}
							}*/
							ans = Math.min(abs, ans);
							
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
