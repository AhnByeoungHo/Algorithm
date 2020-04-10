package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swexpert_1251_D4_Kruskal {
	static class Pair implements Comparable<Pair>{
		long dis;
		int v1,v2;
		public Pair(long dis, int v1, int v2) {
			this.dis = dis;
			this.v1 = v1;
			this.v2 = v2;
		}
		@Override
		public int compareTo(Pair o) {

			return Double.compare(this.dis, o.dis);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int V = Integer.parseInt(bf.readLine());
			int[] x_list = new int[V];
			int[] y_list = new int[V];

			StringTokenizer tks = new StringTokenizer(bf.readLine());
			for (int i = 0; i < V; i++) {                
				int x = Integer.parseInt(tks.nextToken());          
				x_list[i] = x;              
			}

			tks = new StringTokenizer(bf.readLine());
			for (int i = 0; i < V; i++) {
				int y = Integer.parseInt(tks.nextToken());          
				y_list[i] = y;
			}

			double rate = Double.parseDouble(bf.readLine());

			PriorityQueue<Pair> list = new PriorityQueue<>();

			for (int i = 0; i < V-1; i++) {
				for (int j = i+1; j < V; j++) {
					long dis = (long)(x_list[i]-x_list[j])*(long)(x_list[i]-x_list[j])+(long)(y_list[i]-y_list[j])*(long)(y_list[i]-y_list[j]);
					list.add(new Pair(dis,i,j));
				}
			}

			int cnt = 0;

			parent = new int[V];

			for (int i = 0; i < V; i++) {
				parent[i] = i;
			}

			double result = 0;

			while(cnt<V-1) {
				Pair front = list.poll();

				if(pos(front.v1,front.v2)) {
					union(front.v1,front.v2);
					result+=front.dis;
					cnt++;
				}
			}

			result*=rate;
			sb.append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

	static int[] parent;

	private static boolean pos(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if(p1==p2) return false;
		else return true;

	}


	private static int find(int v) {
		if(parent[v]==v) return v;

		return parent[v]=find(parent[v]);
	}

	private static void union(int v1,int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if(p1<p2) {
			parent[p2] = p1;
		}else {
			parent[p1] = p2;
		}

	}
}