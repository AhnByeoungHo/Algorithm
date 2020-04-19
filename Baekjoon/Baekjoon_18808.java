package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_18808 {
	private static int N;
	private static int M;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] paper = new int[N][M];
		
		K = Integer.parseInt(st.nextToken());
		for(int n=0;n<K;n++){
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			boolean finish = false;
			int[][] stiker = new int[R][C];
			int[][] copy = new int[N][M];
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					copy[i][j] = paper[i][j];
				}
			}
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < C; c++) {
					stiker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for(int dir = 0;dir<4;dir++){
				for(int i=0;i<N-stiker.length+1;i++){
					for(int j=0;j<M-stiker[0].length+1;j++){
						
						boolean canin=true;
						for(int r=0;r<stiker.length;r++){
							for(int c=0;c<stiker[0].length;c++){
								if(paper[r+i][c+j]==1 && stiker[r][c]==1) {
									canin = false;
									break;
								}
							}
							if(!canin)break;
						}
						if(canin){
							for(int x=i;x<i+stiker.length;x++){
								for(int y=j;y<j+stiker[0].length;y++){
									if(paper[x][y]==0)
										paper[x][y] = stiker[x-i][y-j];
								}
							}
							finish = true;
							break;
						}
					}
					if(finish) break;
				}
				if(finish) break;
				int[][] temp = new int[stiker[0].length][stiker.length];
				for(int r=0;r<stiker[0].length;r++){
					for(int c=0;c<stiker.length;c++){
						temp[r][c] = stiker[stiker.length-1-c][r];
					}
				}
				stiker = new int[stiker[0].length][stiker.length];
				for(int r=0;r<stiker.length;r++){
					for(int c=0;c<stiker[0].length;c++){
						stiker[r][c] = temp[r][c];
					}
				}
			}
		}
		int result = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				result+=paper[i][j];
			}
		}
		System.out.println(result);
	}
}
