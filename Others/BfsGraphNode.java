package work20200204;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsGraphNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
		String[] sp = src.split(" ");
		StringBuilder sb = new StringBuilder();
		
		LinkedList[] arr = new LinkedList[8];
		boolean[] visit = new boolean[8];
		
		for(int i=0;i<8;i++)
			arr[i] = new LinkedList<>();
		
		for(int i=0;i<sp.length;i+=2) {
			int start = Integer.parseInt(sp[i]);
			int destination = Integer.parseInt(sp[i+1]);
			arr[start].add(destination);

		}

		int start = 1;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			System.out.println(q.toString());
			int cur = q.poll();
			//System.out.println(cur);
			sb.append(cur).append(" ");
			if(visit[cur]) {
				for(int i=0;i<arr[cur].size();i++) {
					int next = (int) arr[cur].get(i);
					if(visit[next]) continue;
					q.offer(next);
					visit[next] = true;
				}
			}
		}
		System.out.println(sb);
	}
}
