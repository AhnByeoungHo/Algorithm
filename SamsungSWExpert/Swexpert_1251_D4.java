package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swexpert_1251_D4 {

	private static double ans;
	private static int N;
	private static int[][] house;
	private static boolean[] visit;
	static long[][] graph;
	private static double E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			sb.append("#").append(tc).append(" ");
			ans = Double.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			house = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++){
				house[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st2.nextToken())};
			}
			
			E = Double.parseDouble(br.readLine());
			
			
			//using dfs is to many case
//			for(int i=0;i<N;i++){
//				visit = new boolean[N];
//				visit[i]= true;
//				dfs(i,0,0);
//			}
			//prim Algorithm
			graph = new long[N][N];
			int[] from,to;
			for(int r=0;r<N;r++){
				from = house[r];
				for(int c=r+1;c<N;c++){
					to = house[c];
					graph[r][c] = ((long)(from[0]-to[0])*(long)(from[0]-to[0])
							+ (long)(from[1]-to[1])*(long)(from[1]-to[1]));
					graph[c][r] = graph[r][c];
				}
			}
			double cost = prim(0) * E;
			cost = Math.round(cost);
			sb.append((long)cost).append("\n");
		}
		System.out.println(sb);
	}
	private static long prim(int start) {
		//mst에 들어가지 않은 녀석들
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//모든정점들을 다관리
		Edge[] dGraph = new Edge[N];
		
		for(int n=0;n<dGraph.length;n++){
			dGraph[n] = new Edge(n, Long.MAX_VALUE);
			if(n==start){
				dGraph[start].cost = 0;
			}
			pq.add(dGraph[n]);
		}
		
		long cost = 0;
		while(!pq.isEmpty()){
			Edge front = pq.poll();
			cost += front.cost;
			
			for(int i=0;i<dGraph.length;i++){
				Edge child = dGraph[i];
				if(!pq.contains(child)) continue;
				long temp = graph[front.idx][child.idx];
				if(temp < child.cost){
					child.cost = temp;
					pq.remove(child);
					pq.add(child);
				}
			}
		}
		
		return cost;
	}
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
		
	}

	private static void dfs(int current, double price,int depth) {
		if(depth==N-1) {
			ans = Math.min(price, ans);
			return;
		}
		if(price>ans){
			return;
		}
		else{
			for(int i=0;i<N;i++){
				if(!visit[i]){
					visit[i] = true;
					double np = E * ((Math.pow((house[current][0]-house[i][0]), 2) 
							+ Math.pow((house[current][1]-house[i][1]), 2)));
					dfs(i,price + np,depth+1);
					visit[i] = false;
				}
			}
		}
		
	}
	

}
