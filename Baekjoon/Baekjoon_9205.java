package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_9205 {

	private static int T;
	private static int N;
	private static ArrayList<Pair> shop;
	private static boolean flag;
	private static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			N = Integer.parseInt(br.readLine());
			flag = false;
			shop = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Pair start = new Pair(x, y);
			for(int n = 0;n<N;n++){
				st = new StringTokenizer(br.readLine()," ");
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				shop.add(new Pair(x,y));

			}
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Pair end = new Pair(x,y);
			visit = new boolean[N];
			
			dfs(end.x, end.y, start.x, start.y);
			
			if(flag) System.out.println("happy");
			else System.out.println("sad");

		}
	}
	public static void dfs(int x, int y,int endx,int endy){
		//System.out.println(x+ " "+ y);
		if(Math.abs(x-endx)+Math.abs(y-endy)<=1000){
			flag = true;
			return;
		}
		else{
			if(flag) return;
			else{
				for(int i=0;i<N;i++){
					if(!visit[i]){
						int nx = shop.get(i).x;
						int ny = shop.get(i).y;
						if((Math.abs(x-nx)+Math.abs(y-ny)) > 1000) continue;
						if(nx==x&&ny==y) continue;
						visit[i] = true;
						dfs(nx, ny, endx, endy);
						if(flag) return;
						//visit[i] = false;
					}
				}
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
