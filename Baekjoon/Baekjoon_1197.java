package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int cost;
	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Integer.compare(cost, o.cost);
	}

}

public class Baekjoon_1197 {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> eList = new PriorityQueue<>();

		for(int i=0;i<E;i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			eList.add(new Edge(from, to, cost));
		}

		int cnt = 0;
		//모든정점 초기화
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		//크루스칼시작
		int result = 0;
		
		while(cnt<V-1) {
			Edge front = eList.poll();
			int p1 = find(front.from);
			int p2 = find(front.to);

			if(p1==p2) continue;
			union(front.from,front.to);
			result+=front.cost;
			cnt++;
			
		}
		System.out.println(result);
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
