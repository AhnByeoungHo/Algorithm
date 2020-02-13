import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Backtracking
 * DFS 시뮬레이션 문제
 * 
 */
public class Main_정올_1113_119구급대 {


	private static int M,N;
	private static int m;
	private static int n;
	private static int[][] map;
	private static int[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//		String[] srr = str.split(" ");				//정규화표현식까지함
		//		System.out.println(Arrays.toString(srr));

		//		StringTokenizer st1 = new StringTokenizer(str);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());	//1 ~100
		N = Integer.parseInt(st.nextToken());	//1 ~100
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0, idx=0 ; j < N; j++,idx+=2) {
				map[i][j] = str.charAt(idx)-'0';
			}
		}

		bfs();
		System.out.println(visit[m][n]);



	} // end of main
	private static final int DOWN = 1;
	private static final int UP = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;
	public static void bfs() {
		// TODO Auto-generated method stub
		//선형큐
		Queue<Pair> q = new LinkedList<>();
		visit = new int[M][N];					//턴의 개수로 방문여부를 체크
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit.length; j++) {
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		//시작지정
		//큐에넣기
		q.offer(new Pair(0,0,0,DOWN));
		q.offer(new Pair(0,0,0,RIGHT));
		visit[0][0]=0;
		//반복
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			int dir = cur.dir;
			int turn = cur.turn;
			int tempturn;//턴의 횟수가 증가하는지에 대한 여부
			// 상
			tempturn = turn + (dir==UP ? 0:1);
			if(0<=curx-1&&visit[curx-1][cury] >= tempturn && map[curx-1][cury]==1) {//범위 체크 이미저장된 && 턴의 회수보다 작을때만 진입
				visit[curx-1][cury] = tempturn;
				q.offer(new Pair(curx-1,cury,tempturn,UP));
			}

			// 하
			tempturn = turn + (dir==DOWN ? 0:1);
			if(M>curx+1&&visit[curx+1][cury] >= tempturn && map[curx+1][cury]==1) {//범위 체크 이미저장된 && 턴의 회수보다 작을때만 진입
				visit[curx+1][cury] = tempturn;
				q.offer(new Pair(curx+1,cury,tempturn,DOWN));
			}	

			// 좌
			tempturn = turn + (dir==LEFT ? 0:1);
			if(0<=cury-1&&visit[curx][cury-1] >= tempturn && map[curx][cury-1]==1) {//범위 체크 이미저장된 && 턴의 회수보다 작을때만 진입
				visit[curx][cury-1] = tempturn;
				q.offer(new Pair(curx,cury-1,tempturn,LEFT));
			}

			// 우
			tempturn = turn + (dir==RIGHT ? 0:1);
			if(N>cury+1&&visit[curx][cury+1] >= tempturn && map[curx][cury+1]==1) {//범위 체크 이미저장된 && 턴의 회수보다 작을때만 진입
				visit[curx][cury+1] = tempturn;
				q.offer(new Pair(curx,cury+1,tempturn,RIGHT));
			}	



		}


	}
	public static class Pair{
		int x;
		int y;
		int turn;
		int dir;

		public Pair(int x, int y, int turn, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.turn = turn;
			this.dir = dir;
		}
	}

} // end of class
