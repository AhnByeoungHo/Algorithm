package swexpert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swexpert_7208_D4 {
	private static int N;
	private static boolean[][] map;
	private static int[] color;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			color = new int [N];
			String line = br.readLine();
			for (int i = 0; i < N; i++) {
				color[i] = line.charAt(i*2)-'0';
			}
			
			map = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				line = br.readLine();
				for (int j = 0; j < map.length; j++) {
					if(line.charAt(j*2)=='1')
						map[i][j] = true;
				}
			}
			ans = Integer.MAX_VALUE;
			permute(0, new int[N]);
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	public static void permute(int depth, int[] output){
		if(depth==N){
			//test
			//System.out.println(Arrays.toString(output));
			boolean cant = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]&& output[i]==output[j]){
						cant=true;
						break;
					}
				}
				if(cant) break;
			}
			
			if(!cant){
				int count=0;
				for (int i = 0; i < output.length; i++) {
					if(color[i]!=output[i]){
						count++;
					}
				}
				ans = Math.min(ans, count);
			}
			
			return;
		}
		
		for (int i = 1; i < 5; i++) {
			output[depth] = i;
			permute(depth+1, output);
		}
	}
}
