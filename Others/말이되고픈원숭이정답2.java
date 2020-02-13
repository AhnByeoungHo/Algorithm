import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *
 * 2. BFS
 * 
 */
public class 말이되고픈원숭이정답2 {

	private static int H;
	private static int W;
	private static int K;
	private static int[][] map;
	private static int minMoveCnt ;
	private static boolean[][][] visit;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1,-1,1,0,0};	//말이동 상하좌우
	static int[] dy = {-2,-1,1,2,2,1,-1,-2,0,0,-1,1};


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());		// 0<=K<=30
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken()); 	//가로 1~200
		H = Integer.parseInt(st.nextToken());	//세로 2~200
		map = new int[H][W];
		
		for(int i=0;i<H;i++) {
			//st = new StringTokenizer(br.readLine());
			String str = br.readLine();
			for(int j=0,idx =0;j<W;j++,idx+=2) {
				map[i][j] = str.charAt(idx)-'0';		//0평지 1장애물
			}
		}
		minMoveCnt = Integer.MAX_VALUE;
		
		// bfs : visit & stack(재귀함수시 안해도됨)
		visit = new boolean[H][W][K+1];
		visit[0][0][K] = true;	//visit 남은 이동횟수
		
		Queue<int[]> q = new LinkedList<>(); // x,y,k 말처럼이동횟수 ,movecnt
		q.offer(new int[]{0,0,K,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curx = cur[0];
			int cury = cur[1];
			int curk = cur[2];
			int curmC = cur[3];
			if(curx==H-1&&cury==W-1) {	//우측하단
				if(minMoveCnt>curmC) minMoveCnt = curmC;
				break;	//bfs특징
			}
			for(int dir=8;dir<12;dir++) {	//상하좌우
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=H||ny>=W) continue;
				if(map[nx][ny]==1) continue;
				if(visit[nx][ny][curk]) continue;
				visit[nx][ny][curk]=true;
				q.offer(new int[] {nx,ny,curk,curmC+1});
			}
			if(curk==0) continue;
			for (int dir = 0; dir < 8; dir++) { //말처럼
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				if(nx<0||ny<0||nx>=H||ny>=W) continue;
				if(map[nx][ny]==1) continue;
				if(visit[nx][ny][curk-1]) continue;
				visit[nx][ny][curk-1]=true;
				q.offer(new int[] {nx,ny,curk-1,curmC+1});
			}
			
		}
		
		System.out.println(minMoveCnt==Integer.MAX_VALUE ? -1:minMoveCnt);
	}
}
