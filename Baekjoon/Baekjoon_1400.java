package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1400 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0&&M==0) {
				break;
			}
			char[][] map = new char[N][M];
			int lightNum = 0;
			
			Queue<int[]> q = new LinkedList<int[]>();
			boolean[][][] visit = new boolean[10][N][M];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j]>='0'&& map[i][j]<='9'){
						lightNum++;
					} else if(map[i][j]=='A'){
						q.add(new int[]{i,j,0,1});
						visit[0][i][j] = true;
					}
					
				}
			}
			Light[] larr = new Light[lightNum];
			for (int i = 0; i < larr.length; i++) {
				larr[i] = new Light();
			}
			for (int i = 0; i < lightNum; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int id = Integer.parseInt(st.nextToken());
				
				char d = st.nextToken().charAt(0);
				if(d=='|'){
					larr[id].startdir=1;
				} else {
					larr[id].startdir=0;
				}
				larr[id].rl = Integer.parseInt(st.nextToken());
				larr[id].ud = Integer.parseInt(st.nextToken());
			}
			
			br.readLine();
			int ans = 0;
			while(!q.isEmpty()){
				
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int curkey = cur[2];
				int curt = cur[3];
				//System.out.println(Arrays.toString(cur));
				if(map[curx][cury]=='B'){
					ans = curt;
					break;
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx +dx[dir];
					int ny =cury +dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(visit[curkey][nx][ny]) continue;
					if(map[nx][ny]=='.')continue;
					if(map[nx][ny]=='#'||map[nx][ny]=='B'){
						q.add(new int[]{nx,ny,curkey,curt+1});
						visit[curkey][nx][ny] = true;
					}
					if(map[nx][ny]>='0'&& map[nx][ny]<='9'){
						//현재 시간에 이방향으로 들어갈수 있는지검사
						//startdir이 -일떄
						Light curl = larr[map[nx][ny]-'0'];
						if(visit[map[nx][ny]-'0'][nx][ny]) continue;
						boolean cango = false;
						if(curl.startdir==0){
							int sum = curl.rl + curl.ud;
							if((curt!=0 && curt%sum==0) || curt%sum>curl.rl){
								if(dir==0||dir==2) cango=true;
							} else {
								if(curt%sum!=0 && curt%sum<=curl.rl){
									if(dir==1||dir==3) {
										cango=true;
									}
								}
							}
						} else { //startdir이 |일떄
							int sum = curl.rl + curl.ud;
							if((curt!=0 && curt%sum==0) || curt%sum>curl.ud){
								if(dir==1||dir==3) cango=true;
							} else {
								if(curt%sum!=0 && curt%sum<=curl.ud){
									if(dir==0||dir==2) {
										cango=true;
									}
								}
							}
						}
						
						//들어갈수있다면 키표시하고 ㄱㄱ
						if(cango){
							int key = (map[nx][ny]-'0');
							if(visit[key][nx][ny]) continue;
							q.add(new int[]{nx,ny,key,curt+1});
							visit[key][nx][ny] = true;
						}
						//못들어간다면 제자리에서 기다리기
						else {
							q.add(new int[]{curx,cury,curkey,curt+1});
						}
					}
				}
			}
			if(ans==0)System.out.println("impossible");
			else {
				ans--;
				System.out.println(ans);
			}
			//break;
		}
		
	}
	public static class Light{
		int startdir;//-:0   |:1
		int rl;
		int ud;
		public Light(){}
		public Light(int startdir, int rl, int ud) {
			this.startdir = startdir;
			this.rl = rl;
			this.ud = ud;
		}
		
	};
}
