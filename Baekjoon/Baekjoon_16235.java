package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_16235 {
	private static int N;
	private static int K;
	private static int M;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] seed = new int[N][N];
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				seed[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		Deque<Tree> q = new ArrayDeque<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int old = Integer.parseInt(st.nextToken());
			q.add(new Tree(x, y, old));
		}
		
		for (int i = 0; i < K; i++) {
			//spring
			Deque<Tree> save = new ArrayDeque<>();
			Deque<Tree> dead = new ArrayDeque<>();
			while(!q.isEmpty()){
				Tree t = q.poll();
				int curx = t.x;
				int cury = t.y;
				int curold = t.old;
				if(map[curx][cury]-curold>=0){
					save.add((new Tree(curx, cury, curold+1)));
					map[curx][cury]-=curold;
				} else {
					dead.add(new Tree(curx,cury,curold));
				}
			}
			while(!save.isEmpty()){
				q.add(save.poll());
			}
			//summer
			while(!dead.isEmpty()){
				Tree d = dead.poll();
				map[d.x][d.y] += d.old/2;
			}
			//fall
			while(!q.isEmpty()){
				Tree s = q.poll();
				int curx = s.x;
				int cury = s.y;
				int curold = s.old;
				save.add(s);
				if(curold%5==0){
					for (int dir = 0; dir < 8; dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0||nx>=N||ny>=N) continue;
						save.addFirst((new Tree(nx, ny, 1)));
					}
				}
			}
			while(!save.isEmpty()){
				q.add(save.poll());
			}
			//winter
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					map[a][b] += seed[a][b];
				}
			}
		}
		System.out.println(q.size());
	}
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int old;
		
		public Tree(int x, int y, int old) {
			super();
			this.x = x;
			this.y = y;
			this.old = old;
		}

		@Override
		public int compareTo(Tree o) {
			Integer old1 = this.old;
			Integer old2 = o.old;
			return old1.compareTo(old2);
		}
	}
}
