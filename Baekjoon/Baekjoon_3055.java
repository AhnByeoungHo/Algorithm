package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_3055 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		Queue<int[]> animal = new LinkedList<int[]>();
		Queue<int[]> water = new LinkedList<>();
		boolean[][] wvisit = new boolean[N][M];
		boolean[][] avisit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j]=='S'){
					animal.add(new int[]{i,j});
					avisit[i][j] = true;
					map[i][j]='.';
				} else if(map[i][j]=='*'){
					water.add(new int[]{i,j});
					wvisit[i][j] = true;
				}
			}
		}
		String ans = "";
		int time = 0;
		while(true){
			
			int wsize = water.size();
			while(wsize!=0){
				int[] curwater = water.poll();
				int curx = curwater[0];
				int cury = curwater[1];
				//System.out.println("w: "+curx+" "+cury);
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(wvisit[nx][ny]) continue;
					if(map[nx][ny]=='*'||map[nx][ny]=='D'||map[nx][ny]=='X') continue;
					wvisit[nx][ny] = true;
					map[nx][ny] = '*';
					water.add(new int[]{nx,ny});
				}
				wsize--;
			}
			
			boolean end = false;
			int asize = animal.size();
			while(asize!=0){
				int[] curan = animal.poll();
				int curx = curan[0];
				int cury = curan[1];
				//System.out.println("a: "+curx+" "+cury);
				if(map[curx][cury]=='D'){
					end = true;
					break;
				}
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = curx + dx[dir];
					int ny = cury + dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=M) continue;
					if(avisit[nx][ny]) continue;
					if(map[nx][ny]=='*'||map[nx][ny]=='X') continue;
					avisit[nx][ny] = true;
					animal.add(new int[]{nx,ny});
				}
				asize--;
			}
			if(end){
				break;
			}
			time++;
			if(water.isEmpty()&&animal.isEmpty()){
				ans = "KAKTUS";
				break;
			}
		}
		if(ans.equals("KAKTUS"))
			System.out.println(ans);
		else
			System.out.println(time);
		
		
	}
}
