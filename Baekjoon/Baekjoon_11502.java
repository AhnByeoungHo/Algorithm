package bak20200206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 6.
 * @see https://www.acmicpc.net/problem/11502
 * @mem
 * @time
 * @caution
 * 
 * */


public class Baekjoon_11502 {

	static boolean found;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=2;i<1000;i++) {
			for(int j=2;j<=i;j++) {
				if(i%j==0 && j==i)
					arr.add(j);
				if(i%j==0 && j!=i) 
					break;
			}
		}
		
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			int[] output = new int[3];
			found = false;
			dfs(0,output,arr,N);
			if(!found)System.out.println(0);
		}
		

		
	}
	public static void dfs(int depth,int[] output,ArrayList<Integer> arr,int n) {
		if(depth==3 || found) {
			if(output[0]<=output[1]&&output[1]<=output[2]) {
				int sum=0;
				for(int i=0;i<3;i++)
					sum+=output[i];
				if(sum==n){
					for(int i=0;i<3;i++)
						System.out.print(output[i]+" ");
					System.out.println();
					found = true;
					return;
				}

			}
			return;
		}
		else {
			for(int i=0;i<arr.size();i++) {
				output[depth] = arr.get(i);
				dfs(depth+1, output, arr,n);
			}
			return;
		}
	}

}
