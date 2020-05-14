package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swexpert_5643_D4 {
	private static Stack<int[]> s;

	private static int N;
	private static int M;
	private static boolean[] visit;
	private static ArrayList[] up;
	private static ArrayList[] down;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			up = new ArrayList[N+1];
			down = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				up[i] = new ArrayList<>();
				down[i] = new ArrayList<>();
			}
			M = Integer.parseInt(br.readLine());
			/* Using BFS
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				up[a].add(b);
				down[b].add(a);
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				Queue<Integer> q = new LinkedList<>();
				visit = new boolean[N+1];
				visit[i] = true;
				q.add(i);	
				
				while(!q.isEmpty()){
					int cur = q.poll();
					for (int j = 0; j < up[cur].size(); j++) {
						int nx = (int) up[cur].get(j);
						if(visit[nx]) continue;
						q.add(nx);
						visit[nx] = true;
					}
				}
				int upcount = 0;
				for (int j = 1; j < visit.length; j++) {
					if(visit[j]) upcount++;
				}
				
				visit = new boolean[N+1];
				visit[i] = true;
				q.add(i);	
				while(!q.isEmpty()){
					int cur = q.poll();
					for (int j = 0; j < down[cur].size(); j++) {
						int nx = (int) down[cur].get(j);
						if(visit[nx]) continue;
						q.add(nx);
						visit[nx] = true;
					}
				}
				int downcount = 0;
				for (int j = 1; j < visit.length; j++) {
					if(visit[j]) downcount++;
				}
				
				if((upcount+downcount-1)==N){
					ans++;
				}	
			}
			System.out.println("#"+tc+ " "+ans);*/
			
			
			//Using Floid washar
			int[][] D= new int[N+1][N+1];
			int[][] U = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
				Arrays.fill(U[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				D[a][b] = 1;
				U[b][a] = 1;
			}
			
			for (int k = 1; k < D.length; k++) {//경유지점
				for (int i = 1; i < D.length; i++) {//출발지점
					if(k==i) continue;
					for (int j = 1; j < D.length; j++) {//도착지점
						if(k==j || i==j) continue;
						if( D[i][k]!=Integer.MAX_VALUE && D[k][j] !=Integer.MAX_VALUE
								&&D[i][j] > D[i][k] + D[k][j]){
							D[i][j] = D[i][k] + D[k][j];
						}
						if( U[i][k]!=Integer.MAX_VALUE && U[k][j] !=Integer.MAX_VALUE
								&&U[i][j] > U[i][k] + U[k][j]){
							U[i][j] = U[i][k] + U[k][j];
						}
					}
				}
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				int ucount = 0;
				int dcount = 0;
				for (int j = 1; j <= N; j++) {
					if(D[i][j]!=Integer.MAX_VALUE) dcount++;
					if(U[i][j]!=Integer.MAX_VALUE) ucount++;
				}
				if((ucount+dcount+1)==N){
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
			
		}	
	}
}
