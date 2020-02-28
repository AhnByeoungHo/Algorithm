package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swexpert_2112 {

	static int D,W,K;
	private static int[][] map,copy;
	private static boolean flag;
	private static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++){
			String line = br.readLine();
			st = new StringTokenizer(line," ");

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			copy = new int[D][W];
			for(int i=0;i<D;i++){
				String l = br.readLine();
				for(int j=0;j<W;j++){
					map[i][j] = l.charAt(j*2)-'0';
					copy[i][j] = map[i][j];
				}
			}
	
			if(K==1)
			{
				System.out.println("#"+tc+" 0");
				continue;
			}
			flag = false;
			MIN = Integer.MAX_VALUE;
			
			//30개부터 시간초과
//			for(int i=0;i<K+1;i++){
//				dfs(i,0,0,new int[i]);
//				if(flag){
//					System.out.println("#"+tc+" "+i);
//					break;
//				}
//			}
			//23개 부터 시간초과
			
			dfs2(K, 0, new boolean[D],0);
			System.out.println("#"+tc+" "+MIN);
		}

	}
	private static void dfs2(int r, int depth,boolean [] visit,int start){
		if(depth>K) 
			return;
		if(depth>MIN) 
			return;
		if(test()){
			MIN = Math.min(MIN, depth);
			return;
		}
		
		for(int i=start;i<D;i++){
			if(!visit[i]){
				for(int c= 0;c<2;c++){
					for(int j=0;j<W;j++){
						copy[i][j] = c;
					}
					visit[i] = true;
					dfs2(r, depth+1, visit,i+1);
					visit[i] = false;
					
				}
				for(int j=0;j<W;j++){
					copy[i][j] = map[i][j];
				}
			}
		}
	}
	private static void dfs(int r, int depth, int start,int[] output) {
		if(flag) return;
		if(r==depth){
			int[] temp = new int[r];
			for(int i=0;i<r;i++){
				temp[i] = output[i];
			}
			powerSet(r,0,temp,new boolean[r]);

			return;
		}
		else{
			for(int i=0;i<D;i++){
				output[depth] = i;
				dfs(r, depth+1, i+1, output);
				if(flag){
					return;
				}
			}
		}

	}

	private static void powerSet(int r, int depth, int[] temp, boolean[] output) {
		if(flag) return;
		if(r==depth){
			for(int i=0;i<temp.length;i++){
				for(int j=0;j<W;j++){
					if(output[i])
						copy[temp[i]][j] = 1;
					else
						copy[temp[i]][j] = 0;
				}
			}
			if(test()){
				flag = true;
			}
			for(int i=0;i<temp.length;i++){
				for(int j=0;j<W;j++){
					copy[temp[i]][j] = map[temp[i]][j];
				}
			}

			return;
		}
		output[depth] = true;
		powerSet(r, depth+1, temp, output);
		output[depth] = false;
		powerSet(r, depth+1, temp, output);

	}
	private static boolean test() {

		int rc = 0;
		for(int j=0;j<W;j++){
			int start = copy[0][j];
			int count = 1;
			for(int i=1;i<D;i++){
				if(i>=D-K+1 && copy[i][j]!=start) {
					return false;
				}
				if(start==copy[i][j])
					count++;
				else
				{
					start = copy[i][j];
					count = 1;
				}
				if(count==K) {
					rc++;
					break;
				}
				
			}
		}
		return true;
	}

}
