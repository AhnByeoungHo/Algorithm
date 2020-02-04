package work20200204;

import java.util.Arrays;

public class Permutation2 {

	static char[] arr = {'A','B','C'};
	static int N = arr.length;
	static boolean[] childs = {true,false};
	static boolean[] visit = new boolean[N];
	static char[] output = new char[N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(0,N);
		
	}
	public static void dfs(int k, int input) {
		if(k==input) {
			printSolution();
		}
		else {
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					visit[i] = childs[0];
					output[k] = arr[i];
					dfs(k+1,input);
					visit[i] = childs[1];
				}
				
			}
		}
	}
	public static void printSolution() {
		for(int i=0;i<N;i++) {
			if(visit[i]) System.out.print(output[i] + " ");
		}
		System.out.println();
	}

}
