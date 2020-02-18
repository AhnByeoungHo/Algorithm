package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11660 {

	private static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=1;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<N;j++){
				if((i!=1&&j==1))
					map[i][j] = map[i-1][j] + Integer.parseInt(st.nextToken());
				else if((i==1&&j!=1)){
					map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
				}
				else
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=2;i<N;i++){
			for(int j=2;j<N;j++){
				
				map[i][j] = map[i][j]+map[i-1][j]+map[i][j-1]-map[i-1][j-1];
				
			}
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int startx = Integer.parseInt(st.nextToken())-1;
			int starty = Integer.parseInt(st.nextToken())-1;
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			if(startx<0||starty<0||endx>=N||endy>=N) continue;
			if(startx==0&&starty==0)
				System.out.println(map[endx][endy]);
			else
				System.out.println(map[endx][endy]-map[endx][starty]-map[startx][endy]+map[startx][starty]);
		}

	}

}
