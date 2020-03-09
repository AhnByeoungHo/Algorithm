package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swexpert_7793_D5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] map = new char[N][M];
			boolean[][] visitDv = new boolean[N][M];
			boolean[][] visitSu = new boolean[N][M];
			int[] dx = {0,-1,0,1};
			int[] dy = {1,0,-1,0};
			int sx=0,sy=0,ex=0,ey=0;
			
			
			int ans = -1;
			Queue<int[]> q = new LinkedList<>();
			
			
			for(int i=0;i<N;i++){
				String line = sc.next();
				for(int j=0;j<M;j++){
					map[i][j] = line.charAt(j);
					if(map[i][j]=='S'){
						visitSu[i][j] = true;
						sx = i;
						sy = j;
					}
					else if(map[i][j] == 'D'){
						ex = i;
						ey = j;
					}
					else if(map[i][j]=='*'){
						visitDv[i][j] = true;
						q.offer(new int[]{i,j,0,1});
					}
				}
			}
			q.offer(new int[]{sx,sy,1,1});
			
			while(!q.isEmpty()){
				int[] cur = q.poll();
				int curx = cur[0];
				int cury = cur[1];
				int dors = cur[2];
				int time = cur[3];
				if(curx==ex&&cury==ey){
					ans = time;
					break;
				}
				if(dors==0){
					for(int dir=0;dir<4;dir++){
						int nx = curx+dx[dir];
						int ny = cury+dy[dir];
						if(nx<0||ny<0||nx>=N||ny>=M) continue;
						if(visitDv[nx][ny] || map[nx][ny]!='.') continue;
						q.offer(new int[]{nx,ny,0,time+1});
						visitDv[nx][ny] = true;
					}
				}
				else{
					for(int dir=0;dir<4;dir++){
						int nx = curx+dx[dir];
						int ny = cury+dy[dir];
						if(nx<0||ny<0||nx>=N||ny>=M) continue;
						if(visitDv[nx][ny] || map[nx][ny]=='X' || visitSu[nx][ny]) continue;
						q.offer(new int[]{nx,ny,1,time+1});
						visitSu[nx][ny] = true;
					}
				}
			}
			
			if(ans==-1) System.out.println("#"+tc+ " GAME OVER");
			else System.out.println("#"+tc+ " "+(ans-1));
			
		}
	}

}
