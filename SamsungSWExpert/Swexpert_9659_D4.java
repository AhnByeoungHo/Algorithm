package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_9659_D4 {
	private static int N;
	private static int M;
	private static long[] x;
	private static long[] fun;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			fun = new long[N+1];
			fun[0] = 1;
			int[] t = new int[N+1];
			int[] a = new int[N+1];
			int[] b = new int[N+1];
			StringTokenizer st;
			for(int i=2;i<N+1;i++){
				st = new StringTokenizer(br.readLine()," ");
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			M =Integer.parseInt(br.readLine());
			x = new long[M+1];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=1;i<M+1;i++){
				x[i] = Long.parseLong(st.nextToken());
			}
			for(int i=1;i<M+1;i++){
				fun[1] = x[i]%998244353;
				for(int j=2;j<N+1;j++){
					fun[j] = -1;
				}
				for(int j=2;j<N+1;j++){
					if(t[j]==1) t1(j,a[j],b[j]);
					else if(t[j]==2) t2(j,a[j],b[j]);
					else if(t[j]==3) t3(j,a[j],b[j]);
				}
				//System.out.println(Arrays.toString(fun));
				sb.append(fun[N]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void t1(int idx, int a, int b){
		if(fun[idx]!=-1) return;
		long result =  (fun[a] + fun[b])%998244353;
		
		fun[idx] = result;
	}
	public static void t2(int idx,int a, int b){
		if(fun[idx]!=-1) return;
		long result = (a * fun[b])%998244353;
		fun[idx] = result;
	}
	public static void t3(int idx,int a, int b){
		if(fun[idx]!=-1) return;
		long result = (fun[a]*fun[b])%998244353;
		fun[idx] = result;
	}
}
