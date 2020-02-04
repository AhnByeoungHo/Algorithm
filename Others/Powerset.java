package work20200204;

import java.util.Arrays;

public class Powerset {

	//static char[] arr = {'A','B','C'};
	static int[] arr = {1,2,3,4,5,6,7,8,9,10};
	static int N = arr.length;
	static boolean[] childs = {true,false};
	static boolean[] subset = new boolean[N];
	
	public static void main(String[] args) {
		dfs(0,N);
	}
	public static void dfs(int k, int input) {
		int sum = sumarr();
		if(sum>10) return;
		if(sum==10) {
			printSolution();
			return;
		}
		if(k==input) {
			return;
		}
		else {
			for(int i=0;i<2;i++) {
				subset[k] = childs[i];
				dfs(k+1,input);
			}
		}
	}
	public static void printSolution() {
		//System.out.print(Arrays.toString(subset)+" : ");
		for(int i=0;i<N;i++) {
			if(subset[i]) System.out.print(arr[i] + " ");
			//else System.out.print(0+" ");
		}
		System.out.println();
	}
	public static int sumarr() {
		int sum = 0;
		for(int i=0;i<N;i++) {
			if(subset[i]) sum += arr[i];
			//else System.out.print(0+" ");
		}
		return sum;
	}
}
