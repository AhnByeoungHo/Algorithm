package bak20200211;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_11724 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List[] list = new LinkedList[N+1];
		boolean[] visit = new boolean[N+1];
		for(int i=0;i<N+1;i++)
			list[i] = new LinkedList();
		for(int i=0;i<M;i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			list[first].add(second);
			list[second].add(first);
		}
//		for(int i=1;i<N+1;i++) {
//			System.out.println(list[i]);
//		}
		int count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<N+1;i++) {
			
			if(!visit[i]) {
				count++;
				q.offer(i);
				while(!q.isEmpty()) {
					int cur = q.poll();

					for(int d =0;d<list[cur].size();d++) {
						int next = (int) list[cur].get(d);
						if(list[next]==null) continue;
						if(visit[next]) continue;
						visit[next] = true;
						q.offer(next);
					}
				}
				
			}
		}
		System.out.println(count);
		
		
	}

}
