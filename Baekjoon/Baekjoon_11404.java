package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11404 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int edgeNum = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for(int e = 0;e<edgeNum;e++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			if(map[x][y]>cost)
				map[x][y] = cost;
			//map[y][x] = cost;
			//System.out.println(x + " "+y+ " "+map[x][y]);
		}
		
		for(int k=0;k<n;k++){
			for (int i = 0; i < n; i++) {
				if(k==i) continue;
				for (int j = 0; j < n; j++) {
					if(k==j || i==j) continue;
					if(map[i][k]==Integer.MAX_VALUE || map[k][j]==Integer.MAX_VALUE) continue;
					if(map[i][j] > map[i][k] + map[k][j]){
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==Integer.MAX_VALUE) sb.append(0 + " ");
				else sb.append(map[i][j]+ " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
