package bak20200218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_1247_D5 {

	private static int T;
	private static int N;
	private static boolean[] visit;
	private static Point[] p;
	private static int MIN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine())+2;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			p = new Point[N];
			p[0] =  new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			p[N-1] =  new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			for(int i=1;i<N-1;i++) {
				p[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			visit = new boolean[N];
			MIN = Integer.MAX_VALUE;

			per(1, p[0], 0);
			
			System.out.println("#"+tc+" "+MIN);
		}
		
		
		
		
	}
	public static void per(int depth, Point cur,int dis) {
		//System.out.println(cur);
		if(depth<N&&cur.x==p[N-1].x&&cur.y==p[N-1].y) {
			return;
		}
		if(dis>MIN) return;
		if(depth==N) {
			MIN = Integer.min(MIN, dis);
			return;
		}
		else {
			for(int i=1;i<N;i++) {
				if(!visit[i]) {
					visit[i] = true;
					Point next = p[i];
					int abs = dis + Math.abs(cur.x-next.x)+Math.abs(cur.y-next.y);
					per(depth+1, next, abs);
					visit[i] = false;
				}
			}
		}
	}
	static class Point{
		int x;
		int y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+","+y;
		}
	}

}
