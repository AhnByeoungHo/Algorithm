package work20200122;

import java.util.Scanner;

public class bak_15649 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N,r;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		int []map = new int[N];
		int []output = new int[r];
		int []visit = new int[N];
		for(int i=1;i<=N;i++) {
			map[i-1]=i;
		}
		choose(map,output,visit,0,N,r);

	}

	public static void choose(int []map,int[] output,int[] visit,int depth, int n,int r) {
		if(r==depth) {
			for(int i=0;i<r;i++) {
				System.out.print(output[i] +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visit[i] != 1) {
				visit[i] = 1;
				output[depth] = map[i];
				choose(map,output,visit,depth+1,n,r);
				output[depth] = 0;
				visit[i] = 0;
			}
			
			
		}
	}

}
