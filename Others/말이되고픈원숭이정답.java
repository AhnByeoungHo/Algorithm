import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. DFS -> time over
 * 
 * 
 */
public class 말이되고픈원숭이정답 {

	private static int H;
	private static int W;
	private static int K;
	private static int[][] map;
	private static int minMoveCnt ;
	private static boolean[][] visit;


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
		
		// dfs : visit & stack(재귀함수시 안해도됨)
		minMoveCnt = Integer.MAX_VALUE;
		visit = new boolean[H][W];
		visit[0][0] = true;	//visit
		dfs(0,0,K,0);

		System.out.println(minMoveCnt==Integer.MAX_VALUE ? -1:minMoveCnt);
	}

	/*
	 * x,y 현재좌표
	 * k 말처럼 이동할수 있는 남은 횟수
	 * moveCnt 현재까지 이동횟수
	 * 
	 */
	static int[] dx = {-1,-2,-2,-1,1,2,2,1,-1,1,0,0};	//말이동 상하좌우
	static int[] dy = {-2,-1,1,2,2,1,-1,-2,0,0,-1,1};
	private static void dfs(int x, int y, int k, int moveCnt) {
		if(x==H-1 && y==W-1) {		//종료파트, 우측하단
			if(moveCnt < minMoveCnt)
				minMoveCnt = moveCnt;
			return;
		}
		else {
			if(minMoveCnt<=moveCnt) return;
			//재귀파트
			//말처럼이동
			if(k>0) {
				for (int dir = 0; dir < 8; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					//배열범위 유효성체크, 방문햇는지, 갈수있는길인지
					if(nx<0||ny<0||nx>=H||ny>=W) continue;
					if(visit[nx][ny]) continue;
					if(map[nx][ny]==1) continue;
					
					visit[nx][ny] = true;
					dfs(nx, ny, k-1, moveCnt+1);
					visit[nx][ny] = false;
				}
			}
			
			//상하좌우
			for (int dir = 8; dir < 12; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				//배열범위 유효성체크, 방문햇는지, 갈수있는길인지
				if(nx<0||ny<0||nx>=H||ny>=W) continue;
				if(visit[nx][ny]) continue;
				if(map[nx][ny]==1) continue;
				
				visit[nx][ny] = true;
				dfs(nx, ny, k, moveCnt+1);
				visit[nx][ny] = false;
			}
		}
	}
}
