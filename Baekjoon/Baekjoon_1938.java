package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_1938 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		int bcount = 0;
		int ecount = 0;
		Tree start = null;
		Tree end = null;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(bcount==1 && map[i][j]=='B'){

					if(j<N-1&&map[i][j+1]=='B')
						start = new Tree(i, j, 0,0);
					else
						start = new Tree(i,j,1,0);

					bcount++;
				}
				else if(map[i][j]=='B'){
					bcount++;
				} 

				else if(ecount==1 && map[i][j]=='E'){
					if(j<N-1 && map[i][j+1]=='E' )
						end = new Tree(i, j, 0,0);
					else
						end = new Tree(i,j,1,0);
					ecount++;
				} else if(map[i][j]=='E'){
					ecount++;
				}
			}
		}

		Queue<Tree> q = new LinkedList<>();
		boolean[][][] visit = new boolean[2][N][N];
		q.add(start);
		visit[start.gs][start.x][start.y] = true;

		while(!q.isEmpty()){
			Tree cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			int curgs = cur.gs;
			int curt = cur.time;
			if(map[curx][cury]=='1') continue;
			//System.out.println(curx + " "+cury+ "->" +nx+ " "+ny+ " "+curgs+" "+curt);
			//System.out.println(curx + " "+cury+ "->" + " "+curgs+" "+curt);
			if(curx==end.x&& cury==end.y&&curgs==end.gs){
				end.time = curt;
				break;
			}
			if(curgs==0){
				//상
				int nx = curx + dx[0];
				int ny = cury + dy[0];
				if(ny+1 < N &&ny-1 >=0 && nx>=0 && map[nx][ny-1]!='1' && map[nx][ny+1]!='1' && map[nx][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						q.add(new Tree(nx, ny, curgs,curt+1));
						visit[curgs][nx][ny] = true;
					}

				}
				//우
				nx = curx + dx[1];
				ny = cury + dy[1];
				if(ny+1<N&&map[nx][ny+1]!='1'){
					if(!visit[curgs][nx][ny]){
						visit[curgs][nx][ny] = true;
						q.add(new Tree(nx, ny, curgs,curt+1));
					}

				}
				//하
				nx = curx + dx[2];
				ny = cury + dy[2];
				if(ny+1 < N &&ny-1 >=0 && nx < N && map[nx][ny-1]!='1' && map[nx][ny+1]!='1' && map[nx][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						q.add(new Tree(nx, ny, curgs,curt+1));
						visit[curgs][nx][ny] = true;
					}

				}
				//좌
				nx = curx + dx[3];
				ny = cury + dy[3];
				if(ny-1>=0 && map[nx][ny-1]!='1'){
					if(!visit[curgs][nx][ny]){
						visit[curgs][nx][ny] = true;
						q.add(new Tree(nx, ny, curgs,curt+1));
					}

				}
				//회전
				if(curx>0 && cury>0 && curx<N-1 && cury<N-1){
					boolean isone = false;
					for (int k = curx-1; k <= curx+1; k++) {
						for (int k2 = cury-1; k2 <= cury+1; k2++) {
							if(map[k][k2]=='1') isone = true;
						}
					}
					if(!isone){
						if(!visit[1][curx][cury]){
							visit[1][curx][cury] = true;
							q.add(new Tree(curx, cury, 1,curt+1));
						}
					}
				}
			} else{ //세로
				//상
				int nx = curx + dx[0];
				int ny = cury + dy[0];
				if(nx-1>=0 && map[nx-1][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						q.add(new Tree(nx, ny, curgs, curt+1));
						visit[curgs][nx][ny] = true;
					}
				}
				//우
				nx = curx + dx[1];
				ny = cury + dy[1];
				if(nx+1 < N &&nx-1 >=0 && ny < N && map[nx-1][ny]!='1' && map[nx+1][ny]!='1' && map[nx][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						visit[curgs][nx][ny] = true;
						q.add(new Tree(nx, ny, curgs,curt+1));
					}
				}
				//하
				nx = curx + dx[2];
				ny = cury + dy[2];
				if(nx+1<N&&map[nx+1][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						visit[curgs][nx][ny] = true;
						q.add(new Tree(nx, ny, curgs,curt+1));
					}
				}
				//좌
				nx = curx + dx[3];
				ny = cury + dy[3];
				if(nx+1 < N &&nx-1 >=0 && ny>=0 && map[nx-1][ny]!='1' && map[nx+1][ny]!='1' && map[nx][ny]!='1'){
					if(!visit[curgs][nx][ny]){
						q.add(new Tree(nx, ny, curgs,curt+1));
						visit[curgs][nx][ny] = true;
					}

				}
				//턴
				if(curx>0 && cury>0 && curx<N-1 && cury<N-1){
					boolean isone = false;
					for (int k = curx-1; k <= curx+1; k++) {
						for (int k2 = cury-1; k2 <= cury+1; k2++) {
							if(map[k][k2]=='1') isone = true;
						}
					}
					if(!isone){
						if(!visit[0][curx][cury]){
							visit[0][curx][cury] = true;
							q.add(new Tree(curx, cury, 0,curt+1));
						}
					}
				}

			}
		}
		System.out.println(end.time);
	}
	public static class Tree{
		int x;
		int y;
		int gs;//0가로 1세로
		int time;
		public Tree(int x, int y, int gs,int time) {
			this.x = x;
			this.y = y;
			this.gs = gs;
			this.time = time;
		}

	}
}
