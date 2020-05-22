package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_4013 {
	private static int[][] mag;//0-N 1-S(1)
	 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				String line = br.readLine();
				for (int j = 0; j < 8; j++) {
					mag[i][j] = line.charAt(j*2)-'0'; 
				}
			}
			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				//1-시계(+1) -1(반시계-1)
				int mvMag = Integer.parseInt(st.nextToken())-1;
				int orderdir = Integer.parseInt(st.nextToken());
				int notorderdir = orderdir==1 ? -1 : 1;
				boolean[] canrotate = new boolean[3];
				if(mag[0][2]!=mag[1][6]){
					canrotate[0] = true;
				}
				if(mag[1][2]!=mag[2][6]){
					canrotate[1] = true;
				}
				if(mag[2][2]!=mag[3][6]){
					canrotate[2] = true;
				}
				if(mvMag==0){
					//0-1-2-3
					rotate(notorderdir, 0);
					if(canrotate[0]) {
						rotate(orderdir, 1);
						if(canrotate[1]){
							rotate(notorderdir, 2);
							if(canrotate[2]){
								rotate(orderdir, 3);
							}
						}
					}	
				}
				
				else if(mvMag==1){
					//1-0
					//1-2-3
					rotate(notorderdir, 1);
					if(canrotate[0]){
						rotate(orderdir, 0);
					}
					if(canrotate[1]){
						rotate(orderdir, 2);
						if(canrotate[2]){
							rotate(notorderdir, 3);
						}
					}
				}
				
				else if(mvMag==2){
					//2-1-0
					//2-3
					rotate(notorderdir, 2);
					if(canrotate[2]){
						rotate(orderdir, 3);
					}
					if(canrotate[1]){
						rotate(orderdir, 1);
						if(canrotate[0]){
							rotate(notorderdir, 0);
						}
					}
				}
				
				else if(mvMag==3){
					rotate(notorderdir, 3);
					if(canrotate[2]){
						rotate(orderdir, 2);
						if(canrotate[1]){
							rotate(notorderdir, 1);
							if(canrotate[0]){
								rotate(orderdir, 0);
							}
						}
					}
				}
			}
			int ans = 0;
			for (int i = 0, j=1; i < 4; i++,j*=2) {
				ans += mag[i][0]*j;
			}
			System.out.println("#"+tc+" "+ans);	
		}
	}
	static void rotate(int dir, int mnum){
		int[] temp = new int[8];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = mag[mnum][(8+i+dir)%8];
		}
		for (int i = 0; i < temp.length; i++) {
			mag[mnum][i] = temp[i];
		}
	}
}
