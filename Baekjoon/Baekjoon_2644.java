package bak20200219;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2644 {

	private static boolean[] visit;
	private static LinkedList[] fam;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner  sc = new Scanner(System.in);
		int N = sc.nextInt();
		fam = new LinkedList[N+1];
		int start = sc.nextInt();
		int end = sc.nextInt();
		int k = sc.nextInt();
		for(int i=0;i<=N;i++) {
			fam[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<k;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			fam[a].add(b);
			fam[b].add(a);
		}
		visit = new boolean[N+1];
		Queue<int []> q =new LinkedList<>();
		q.offer(new int[] {start,0});
		
		visit[start] = true;
		
		int ans = -1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curn = cur[0];
			int curcount = cur[1];
			
			if(curn==end) {
				ans = curcount;
				break;
			}
			
			for(int i=0;i<fam[curn].size();i++) {
				int nx = (int) fam[curn].get(i);
				if(visit[nx]) continue;
				if(fam[nx]==null) continue;
				q.offer(new int[] {nx,curcount+1});
				visit[nx] = true;
				
			}
		}
		System.out.println(ans);
	}

}
