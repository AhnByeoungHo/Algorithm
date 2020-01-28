package work20200122;

import java.util.Scanner;

public class Swexpert_9229_D3 {

	static int max = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int weight = sc.nextInt();
			max = -1;
			int []snack = new int[N];
			int []visited = new int[N];
			int []output = new int[2];
			for(int i=0;i<N;i++)
				snack[i] = sc.nextInt();
			choose(snack,output,visited,0,N,2,weight);
			System.out.println("#"+t+" "+max);
		}
		
	}
	public static void choose(int []arr, int []output,int []visited,int depth, 
			int n, int r,int w) {
		if(r==depth) {
			int sum = 0;
			for(int i=0;i<r;i++) {
				sum+=output[i];
				//System.out.println("sum "+ sum + "w" + w);
			}
				
			if(sum>=max && sum <=w) {
				max = sum;
			}
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				output[depth] = arr[i];
				choose(arr,output,visited,depth+1,n,r,w);
				output[depth] = 0;
				visited[i] = 0;
			}
			
		}
	}

}
