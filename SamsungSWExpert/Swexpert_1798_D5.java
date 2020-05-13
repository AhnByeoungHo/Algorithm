package swexpert;
// 2 3 9 5 6 10 4 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_1798_D5 {
	private static int M;
	private static int N;
	private static int[][] time;
	private static ArrayList<Building> building;
	private static boolean[] visit;
	static int c;
	private static String ansp;
	private static int s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			time = new int[N][N];

			for (int n = 0; n < N-1; n++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int i = n+1; i < N; i++) {
					time[n][i] = Integer.parseInt(st.nextToken());
					time[i][n] = time[n][i];
				}
			}
			building = new ArrayList<Building>();
			s = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char tmp = st.nextToken().charAt(0);
				if(tmp=='P'){
					building.add(new Building('P', Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				} else {
					building.add(new Building(tmp, 0, 0));
					if(tmp=='A')
						s = i;
				}
			}

			visit = new boolean[N];
			c = 0;
			ansp = "";
			String path="";
			dfs(s,1,0,c,path);
			System.out.println("#"+tc+" "+c+" "+ansp);

		}
	}
	public static void dfs(int start, int day,int miniute,int cost,String path){
		if(day==M && start==s) {
			if(c<cost){
				c = cost;
				ansp = path;
				return;
			}
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if(i!=start && !visit[i]){
				int mvtime = time[start][i];
				if(building.get(i).what=='P'){
					int ncost = cost + building.get(i).cost;
					int m = miniute + building.get(i).t;
					if(m + mvtime <=540){
						flag = true;
						visit[i] = true;
						dfs(i, day, m+mvtime,ncost,path+(i+1)+" ");
						visit[i] = false;
					} 
				}
			}
		}
		if(!flag && building.get(start).what=='P' &&day<M)
			for (int j = 0; j < N; j++) {
				if(building.get(j).what=='H'){
					if(miniute+time[start][j]<=540)
						dfs(j, day+1, 0 ,cost,path+(j+1)+" ");
				}	
			}
		if(!flag && building.get(start).what=='P' &&day==M)
			for (int i = 0; i < N; i++) {
				if(building.get(i).what=='A'){
					if(miniute+time[start][i]<=540){
						dfs(i, day,miniute+time[start][i] ,cost,path+(i+1)+" ");
					}
				}
			}
	}

	static class Building{
		char what;
		int t;
		int cost;
		public Building(char what, int t, int cost) {
			this.what = what;
			this.t = t;
			this.cost = cost;
		}
	}
}
