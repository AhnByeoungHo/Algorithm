package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_4012 {

	private static int N;
	private static int[][] map;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			combi(0,N/2,0,new int[N/2]);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
			
	}

	static int tsum = 0;
	static int fsum = 0;
	private static void combi(int depth, int r,int start,int[] output) {
		if(depth==r){
			boolean[] temp = new boolean[N];
			for(int i=0;i<r;i++){
				temp[output[i]] = true;
			}
			tsum=0;
			fsum=0;
			select2(temp,0,0,new int[2]);
			select3(temp,0,0,new int[2]);
			ans = Math.min(ans, Math.abs(tsum-fsum));
			return;
		}

		for(int i=start;i<N-1;i++){
			output[depth] = i;
			combi(depth+1, r, i+1,output);
		}
		
	}

	private static void select2(boolean[] temp, int start, int depth,int[] output) {
		if(depth==2){
			tsum += map[output[0]][output[1]] + map[output[1]][output[0]];
			return;
		}
		for(int i=start;i<N;i++){
			if(temp[i]){
				output[depth] = i;
				select2(temp, i+1, depth+1,output);
			}
		}
		
	}
	private static void select3(boolean[] temp, int start, int depth,int[] output) {
		if(depth==2){
			fsum += map[output[0]][output[1]] + map[output[1]][output[0]];
			return;
		}
		for(int i=start;i<N;i++){
			if(!temp[i]){
				output[depth] = i;
				select3(temp, i+1, depth+1,output);
			}
		}
		
	}

}
