package bak20200207;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_16987 {
	static int N;
	static int ans = Integer.MIN_VALUE;
	static int ans2 = Integer.MIN_VALUE;
	private static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Egg[] el = new Egg[N];
		for(int i=0;i<N;i++) {
			int s = sc.nextInt();
			int w = sc.nextInt();
			el[i] = new Egg(s,w);
		}
		Egg[] output = new Egg[N];
		for(int i=0;i<N;i++) {
			output[i] = el[i];
		}
		dfs(output ,visit, 0);
		System.out.println(ans);
	}
	public static void dfs(Egg[] output,boolean[] visit,int id) {
		int sum = 0;
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			if(output[i].s>0) {
				visit[i] = false;
			}
			else {
				sum++;
				visit[i] = true;
			}
		}
		ans = Math.max(sum, ans);
		if(id==N) {	
			return;
		}
		if(visit[id]) {
			dfs(output, visit, id+1);
		}
		else {
			for(int i=0;i<N;i++) {
				if(!visit[i] && id!=i) {

					output[id].s -= output[i].w;
					output[i].s -= output[id].w;

					dfs(output, visit, id+1);

					output[id].s += output[i].w;
					output[i].s += output[id].w;
				}
			}
		}
	}
	static class Egg{
		int s;
		int w;
		Egg(int s,int w){
			this.s =s;
			this.w=w;

		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return s + ","+ w;
		}
	}

}
