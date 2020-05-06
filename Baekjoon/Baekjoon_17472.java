package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17472 {
	private static int M;
	private static int N;
	private static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static int[][] copymap;
	private static int count;
	private static ArrayList[] link;
	private static int[][] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				 map[i][j] = line.charAt(2*j) - '0';
			}
		}
		//다리는 바다만(0) 길이는 칸수 다리는1자 길이 2이상
		//섬갯수찾기 및 섬번호 마킹
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		copymap = new int[N][M];
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j] && map[i][j]!=0){
					count++;
					q.add(new int[]{i,j});
					visit[i][j] = true;
					copymap[i][j] = count;
					
					while(!q.isEmpty()){
						int[] cur = q.poll();
						int curx = cur[0];
						int cury = cur[1];
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = curx + dx[dir];
							int ny = cury + dy[dir];
							if(nx<0||ny<0||nx>=N||ny>=M) continue;
							if(visit[nx][ny]) continue;
							if(map[nx][ny]==0) continue;
							q.add(new int[]{nx,ny});
							visit[nx][ny] = true;
							copymap[nx][ny] = count;
						}
					}
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(copymap[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(count);
		
		
		//섬을 큐에넣고 동시에 퍼트리기 가지고다니는파라미터는 위치, 방향, 움직인거리, 어느섬에서출발했는지
		Queue<int[]> q2 = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copymap[i][j]!=0){
					for (int dir = 0; dir < 4; dir++) {
						q2.add(new int[]{i,j,dir,0,copymap[i][j]});
					}
				}
			}
		}
	
		cost = new int[count][count];
		link = new ArrayList[count];
		for (int i = 0; i < count; i++) {
			link[i] = new ArrayList<>();
		}
		while(!q2.isEmpty()){
			int[] cur = q2.poll();
			int curx = cur[0];
			int cury = cur[1];
			int d = cur[2];
			int dis = cur[3];
			int num = cur[4];
			
			int nx = curx + dx[d];
			int ny = cury + dy[d];
			
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(copymap[nx][ny]==num) continue;
			if(map[nx][ny]!=0 && copymap[nx][ny] !=num  && dis >1){
				
				if(cost[num-1][copymap[nx][ny]-1]!=0) 
					dis = Math.min(dis, cost[num-1][copymap[nx][ny]-1]);
				cost[num-1][copymap[nx][ny]-1] = dis;
				cost[copymap[nx][ny]-1][num-1] = dis;
				
				link[num-1].add(copymap[nx][ny]-1);
				link[copymap[nx][ny]-1].add(num-1);
			}
			if(map[nx][ny]==0){
				q2.add(new int[]{nx,ny,d,dis+1,num});
			}
		}
		
		//prim
		boolean[] check = new boolean[count];
		int[] key = new int[count]; //현재 선택된 정점들로부터 도달할수 있는 최소거리
		int[] p = new int[count]; // 최소신장트리의 구조를 저장할 배열
		Arrays.fill(key, Integer.MAX_VALUE);
		//키의 초기값은 무한대
		
		//아무거나 하나 선택(처음선택되는 친구가 루트이므로 부모가 없는걸로 거리는0)
		p[0] = -1;
		key[0] = 0;
		//이미하나골랏으니 나머지 V-1개고르자
		for(int i=0;i<count-1;i++){
			int min = Integer.MAX_VALUE;
			//안골라진 친구들중에서 key가 가장 작은 친구를 뽑자
			int index = -1;//찾으면 idx기억
			for(int j=0;j<count;j++){
				//일단 안골라진지 검사 key의최소값을 기억해야함
				if(!check[j] && key[j] <min){
					index = j;
					min = key[j];
				}
			}
			//index : 선택이 안도니 정점중 key가 제일 작은 곳이 들어있다
			if(index==-1) continue;
			check[index] = true;
			for(int j=0;j<count;j++){
				//check안되있으면서 간선은존재하고 그 간선이 key값보다 작다면 key값을 업데이트
				if(!check[j] && cost[index][j] != 0 && key[j] > cost[index][j]){
					p[j] = index;
					key[j] = cost[index][j];
				}
			}
		
		}
		
		int result = 0;
		
		for(int i=0;i<count;i++){
			result+= key[i];
		}
		
		boolean[] linktest = new boolean[count];
		Queue<Integer> q3 = new LinkedList<>();
		q3.add(0);
		linktest[0] = true;
		while(!q3.isEmpty()){
			int start = q3.poll();
			for (int i = 0; i < link[start].size(); i++) {
				int end = (int) link[start].get(i);
				if(linktest[end]) continue;
				q3.add(end);
				linktest[end] = true;
			}
		}
		for (int i = 0; i < linktest.length; i++) {
			if(!linktest[i]){
				result = -1;
				break;
			}
		}
		if(result<2) result = -1;
		System.out.println(result);
	}
	
}
