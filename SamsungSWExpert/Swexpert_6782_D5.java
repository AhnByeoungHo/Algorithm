package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swexpert_6782_D5 {
	private static long N;
	static int ans = 0;
	private static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++){
			N = Long.parseLong((br.readLine()));
			memo = new int[1000002];
			ans = Integer.MAX_VALUE;
			dfs(N,0);
			System.out.println("#"+tc+ " "+ans);
			long temp=0;
			int cnt = 0;
			while(true){
				if(N==2) break;
				temp=(long) Math.sqrt(N);
		        if(temp*temp==N){
		            cnt++;
		            N=temp;
		        }
		        else{
		            cnt+=((temp+1)*(temp+1)-N);
		            cnt++;
		            N=temp+1;
		        }
		        
			}
			System.out.println("#"+tc+ " "+cnt);
		}
	}
	public static void dfs(double result,int count){
		//System.out.println(result);
		if(result==2){
			ans = Math.min(ans, count);
			return;
		}
		if(memo[(int)Math.sqrt(result)-1]>count) return;
		if(Math.sqrt(result)*10%10 == 0){
			memo[(int)Math.sqrt(result)-1]++;
			dfs((int)Math.sqrt(result),count+1);
		}
		else{
			dfs(Math.pow(((int)Math.sqrt(result))+1, 2),
					(int)(count+Math.pow(((int)Math.sqrt(result))+1, 2)-result));
		}
		
		
	}
}
