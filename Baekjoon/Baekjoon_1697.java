package bak20200219;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Baekjoon_1697 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt();
		int sister = sc.nextInt();
		int count=0;
		if(sister<subin) count=(subin-sister);
		
		else {
			boolean[] visit = new boolean[100020];
			Queue<int[]> q = new LinkedList<>();
			
			q.offer(new int[] {sister,0});
			visit[sister]=true;
			
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int curx = cur[0];
				int c = cur[1];
				
				
				if(curx==subin) {
					count = c;
					break;
				}
				if(curx==0) {
					q.offer(new int[] {1,c+1});
					visit[1] =true;
					continue;
				}
				
				if(curx%2==0) {
					if(!visit[curx/2]) {
						q.offer(new int[] {curx/2,c+1});
						visit[curx/2] =true;
					}
					if(!visit[curx-1]) {
						q.offer(new int[] {curx-1,c+1});
						visit[curx-1] =true;
					}
					
					if(curx<100010&&!visit[curx+1]) {
						q.offer(new int[] {curx+1,c+1});
						visit[curx+1] =true;
					}
					
				}
				else if(curx%2==1) {
					if(!visit[curx-1]) {
						q.offer(new int[] {curx-1,c+1});
						visit[curx-1] =true;
					}
					
					
					if(curx<100010 &&!visit[curx+1]) {
						q.offer(new int[] {curx+1,c+1});
						visit[curx+1] =true;
					}
					
				}
				
			}
		}
		
		System.out.println(count);
	}

}
