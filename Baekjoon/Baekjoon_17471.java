package bak20200214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 홍길동
 * @since 2020. 2. 14.
 * @see https://www.acmicpc.net/problem/17471
 * @mem 16356
 * @time 156
 * @caution #부분집합, #BFS, #그래프
 */
public class Baekjoon_17471 {
	private static int N;// 지역의 개수
	private static int[] peopleNum;// 지역의 인구
	// graph
	private static List<Integer>[] City;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		peopleNum = new int[N];
		for (int n = 0; n < N; n++) {
			peopleNum[n] = scanner.nextInt();
		}

		// 그래프 초기화
		City = new List[N];
		for (int i = 0; i < City.length; i++) {
			City[i] = new ArrayList<>();
		}

		for (int n = 0; n < N; n++) {
			int C = scanner.nextInt();
			for (int c = 0; c < C; c++) {
				int to = scanner.nextInt() - 1;
				City[n].add(to);
				City[to].add(n);
			}
		}

		// 두 개의 그룹
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i < 1 << N - 1; i++) { // 공집합과 부분집합은 빼고
			List<Integer> g1 = new ArrayList<>();
			List<Integer> g2 = new ArrayList<>();
			
			for(int j=0; j<N; j++) {
				if( (i & 1<<j) >0) {
					g1.add(j);	// 부분집합
				}else {
					g2.add(j);	// 여집합
				}
			}
			// 그룹별 탐색 후 최소 인구 차이 구하기
			int result1 = bfs(g1);
			if(result1 > 0) {
				int result2 = bfs(g2);
				if(result2 >0) {
					min = Math.min(min, Math.abs(result2-result1));
				}
			}

		}
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}
	
	public static int bfs(List<Integer> group) {
		boolean [] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(group.get(0));
		int cnt = 0;		// 탐색한 노드의 수 - group.size() == cnt ==> 성공
		int popSum = 0;		// 인구 수
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			if(visited[front]) {
				continue;
			}
			
			visited[front]=true;
			cnt++;
			popSum+= peopleNum[front];
			// 자식 찾아보기
			List<Integer> childs = City[front];
			// 연결되어있지만 같은 그룹이 아니라면 갈수 없다
			for(Integer child: childs) {
				if(group.contains(child) && !visited[child]) {// 자식이 같은 그룹이고 미방문
					queue.offer(child);
				}
			}
		}
		
		if(cnt==group.size()) {
			return popSum;
		}else {
			return -1;
		}
	}
}
