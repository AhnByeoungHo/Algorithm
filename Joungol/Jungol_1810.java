package bak20200211;

import java.util.Scanner;

public class Jungol_1810 {

	static int N = 9;
	static int r = 7;
	private static int[] data;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		data = new int[N];
		for(int i=0;i<N;i++) {
			data[i] = sc.nextInt();
		}
		int[] output = new int[r];
		combi(r, 0, output, 0);
		
	}
	public static void combi(int r, int depth, int[] output, int start) {
		if(r==depth) {
			int sum=0;
			for(int i=0;i<r;i++) {
				sum+= output[i];
			}
			if(sum==100) {
				for(int i=0;i<r;i++) {
					System.out.println(output[i]);
				}
			}
			return;
		}
		else {
			for(int i=start;i<N;i++) {
				output[depth] = data[i];
				combi(r, depth+1, output, i+1);
			}
		}	
	}
}
