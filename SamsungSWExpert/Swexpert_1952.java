package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_1952 {
	private static int[] price;
	private static int[] plan;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			plan = new int[12];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			ans = price[3];
			dfs(0, 0);
			System.out.println("#"+tc+" "+ans);

		}
	}
	static void dfs(int depth,int cost){
		//System.out.println(depth+" : " +cost);
		if(cost>ans) return;
		boolean test = true;
		for (int i = 0; i < 12; i++) {
			if(plan[i]>0){
				test = false;
			}
		}
		if(test && depth==12){
			ans = Math.min(ans, cost);
			return;
		}

		if(plan[depth]!=0){
			if(depth<10){
				int[] save = new int[3];
				for (int d = depth; d < depth+3; d++) {
					save[d-depth] = plan[d];
					plan[d] = 0;
				}
				dfs(depth+3, cost+price[2]);
				for (int d = depth; d < depth+3; d++) {
					plan[d] = save[d-depth];
				}
			} else if(depth==10){
				int save = plan[11];
				int save2 = plan[10];
				plan[11] = 0;
				plan[10] = 0;
				dfs(depth+1, cost+price[2]);
				plan[11] = save;
				plan[10] = save2;
 			} else if(depth==11){
				int save = plan[11];
				plan[11] = 0;
				dfs(depth+1, cost+price[2]);
				plan[11] = save;
			}
			if(price[0]*plan[depth]>=price[1]){
				int save = plan[depth];
				plan[depth] = 0;
				dfs(depth+1, cost+price[1]);
				plan[depth] = save;
			} else {
				int save = plan[depth];
				plan[depth] = 0;
				dfs(depth+1, cost+price[0]*save);
				plan[depth] = save;
			}
			
		} else {
			dfs(depth+1, cost);
		}

	}
}
