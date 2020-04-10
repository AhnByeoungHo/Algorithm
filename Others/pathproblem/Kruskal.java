package pathproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	static int[] parents;
	static int[] rank;
	//입력은 첫줄에 정점의 갯수오 ㅏ간선의 갯수가 들어오고
	//그다움 부터 간선의 정보가정점1 정점2 가중치 로간선의 갯수만큼 들어옴
	
	public static void main(String[] args) {
		//간선들을 가중치 오름차순 정렬

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][]  edges = new int[E][3];
		for(int i=0;i<E;i++){
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[2], o2[2]);
			}
		});
		//각정점에 대해 유니온파인드 연산준비
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if(a==b)
				continue;
			union(a,b);
			//간선을선택
			result+=edges[i][2];
			cnt++;
			if(cnt==V-1) break;//정점의 갯수 -1 반복하면 그만
		}
		//간선이 연결하는 두정점이 같은 팀이 아니라면 한팀으로 합쳐주고 간선선택
		//같은팀이라면 패스
	}
	
	static void makeSet(int x){
		parents[x] = x;
	}
	static int findSet(int x){
		if(x==parents[x]) return x;
		else {
			//path compression
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	static void union(int x,int y){
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px] > rank[py]){
			parents[py] = px;
		}else{
			parents[px] = py;
			if(rank[px]==rank[py]){
				rank[py]++;
			}
		}
	}
}