package work20200128;

import java.util.Arrays;

public class Permutation {

	static char[] src = {'A','B','C','D'};
	static int[] card = {0,1,2,3,4,5,6,7,8,9};
	static int[] data = {6,6,6,6,7,8};
	//6,6,7,7,6,7
	//0,5,4,0,6,0
	//1,0,1,1,2,3
	static boolean bornot = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] arr = {'A','B','C','D'};
		//int[] visit = new int[arr.length];
		//boolean[] visited = new boolean[src.length];
		//int r = 3;
		//char[] output = new char[r];
		//fun(arr,visit,output,4,r,0);
		//permute(r,output,0,visited);
		//samepermute(r,output,0,visited);
		int[] output2 = new int[6];
		boolean[] visited2 = new boolean[data.length];
		babygin(6,output2,0,visited2);
		if(bornot) {
			System.out.println("baby-gin!!");
		}
		else
			System.err.println("not good number");
		
	}
	public static void babygin(int r, int[] output, int current, boolean[] visited) {
		if(current == r) {
			boolean runright = false,runleft = false;
			boolean tripletright = false,tripletleft = false;
			
			if((output[0]+1==output[1])&&(output[1]+1==output[2])) runleft = true;
			if((output[3]+1==output[4])&&(output[4]+1==output[5])) runright = true;
			if(output[0]==output[1]&&output[1]==output[2]) tripletleft = true;
			if(output[3]==output[4]&&output[4]==output[5]) tripletright = true;
			boolean left = runleft|tripletleft;
			boolean right = runright|tripletright;
			
			if(left&right) {
				System.out.println(Arrays.toString(output));
				bornot = true;
			}
			
			return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				if(!visited[i]) {
					visited[i] = true;
					output[current] = data[i];
					babygin(r,output,current+1,visited);
					output[current] = 0;
					visited[i] = false;
				}
			}
		}
	}
	
	
	public static void fun(char[] arr,int[] visit,char[] output,int n,int r,int depth) {
		if(r==depth) {
			System.out.println(Arrays.toString(output));
			return;
		}
		else {
			for(int i=0;i<n;i++) {
				if(visit[i]==0) {
					visit[i] = 1;
					output[depth] = arr[i];
					fun(arr,visit,output,n,r,depth+1);
					output[depth] = 0;
					visit[i] = 0;
				}
			}
			
		}
	}
	public static void permute(int r, char[] output, int current, boolean[] visited) {
		if(current == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		else {
			for(int i=0;i<src.length;i++) {
				if(!visited[i]) {
					visited[i] = true;
					output [current] = src[i];
					permute(r,output,current+1,visited);
					output[current] = ' ';
					visited[i] = false;
				}
			}
		}
	}
	
	
	public static void samepermute(int r, char[] output, int current, boolean[] visited) {
		if(current==r) {
			int idx=0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					output[idx] = src[i];
					idx++;
				}
			}
			System.out.println(Arrays.toString(visited));
			System.out.println(Arrays.toString(output));
			return;
		}
		else {
			for(int i=0;i<src.length;i++) {
				if(!visited[i]) {
					visited[i] = true;
					samepermute(r,output,current+1,visited);
					visited[i] = false;
				}
			}
		}
		
	}

}
