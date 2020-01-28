package bak20200128;

import java.util.Scanner;

public class Baekjoon_15650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] data = new int[n];
		int[] output = new int[m];
		for(int i=0;i<n;i++)
			data[i] = i+1;
		boolean[] visited = new boolean[n];
		func(m, 0, data, output, visited);
	}
	public static void func(int r, int depth, int[] data,int[] output,boolean[] visit) {
		if(r==depth) {
			for(int i=0;i<output.length-1;i++)
				if(output[i]>output[i+1]) return;
			for(int i=0;i<output.length;i++)
				System.out.print(output[i]+" ");
			System.out.println();
			return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					output[depth] = data[i];
					func(r, depth+1, data, output, visit);
					output[depth] = 0;
					visit[i] = false;
				}
			}
		}
	}

}
