package bak20200218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1780 {

	private static int N;
	private static int[][] map;
	private static int[] count = {0,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<count.length;i++)
			sb.append(count[i]).append(" ");
		System.out.println(sb);
	}
	public static void dfs(int depth,int x, int y) {
		if(depth<1){
			return;
		}
		else {
			boolean isokay=true;
			int pivot = map[x][y];
			for(int i=x;i<x+depth;i++) {
				for(int j=y;j<y+depth;j++) {
					if(pivot!=map[i][j]) {
						isokay = false;
						break;
					}
				}
				if(!isokay) break;
			}
			if(isokay) {
				//System.out.println(x+" "+y+" : "+pivot);
				count[pivot+1]++;
				return;
			}
			else {
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						dfs(depth/3, x+i*depth/3, y+j*depth/3);
					}
				}
			}
		}
	}
}
