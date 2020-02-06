package bak20200206;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 6.
 * @see https://www.acmicpc.net/problem/1260
 * @mem
 * @time
 * @caution
 * 
 * */

class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Baekjoon_1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List[] list = new LinkedList[N];
		for(int i=0;i<N;i++)
			list[i] = new LinkedList<Integer>();

		int M = sc.nextInt();
		int start = sc.nextInt()-1;

		for(int i=0;i<M;i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			list[to].add(from);
			list[from].add(to);
		}
		for(int i=0;i<N;i++) {

			Collections.sort(list[i]);
			//System.out.println(list[i].toString());
		}

		Stack<Integer> s = new Stack<Integer>();

		boolean[] visit = new boolean[N];


		//dfs
		s.push(start);
		visit[start] = true;
		boolean flag;

		System.out.print((start+1) + " ");
		while(!s.isEmpty()) {
			int cur = s.peek();
			flag = false;
			for(int a=0;a<list[cur].size();a++) {
				int nx = (int) list[cur].get(a);
				if(nx<0||nx>=N) continue;
				if(visit[nx]) continue;
				s.push(nx);
				System.out.print((nx+1)+" ");
				visit[nx] = true;
				flag = true;
				break;
			}
			if(!flag) s.pop();
		}
		System.out.println();

		//bfs
		Queue<Integer> q = new LinkedList<Integer>();
		visit = new boolean[N];
		
		q.offer(start);
		visit[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print((cur+1) + " ");
			for(int a=0;a<list[cur].size();a++) {
				int nx = (int) list[cur].get(a);
				if(nx<0||nx>=N) continue;
				if(visit[nx]) continue;
				q.offer(nx);
				visit[nx] = true;
			}
		}

	}

}
