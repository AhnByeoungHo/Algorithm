package bak20200218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_2817_D3 {

	private static int T;
	private static int K;
	private static int N;
	private static boolean[] use = {true,false};
	private static int[] data;
	private static int ans;
	private static boolean[] subset;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			data = new int[N];
			ans = 0;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			subset =  new boolean[N];
			dfs(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	public static void dfs(int depth) {
		if(depth==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(subset[i])
					sum += data[i];
			}
			if(sum==K) {
				ans++;
			}
			return;
		}
		else {
			for(int i=0;i<2;i++) {
				subset[depth] = use[i];
				dfs(depth+1);
			}
		}
	}

}
