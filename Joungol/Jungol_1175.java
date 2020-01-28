package bak20200128;

import java.util.Scanner;

public class Jungol_1175 {

	static int m;
	static int[] dice = {1,2,3,4,5,6};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		m = sc.nextInt();
		int[] output = new int[n];
		samePermute(n, 0, dice, output);

		
		
	}
	public static void samePermute(int r, int depth, int[] data,int[] output) {
		if(r==depth) {
			int sum=0;
			for(int i=0;i<output.length;i++) {
				sum+=output[i];
			}
			if(sum==m)
			{
				for(int i=0;i<output.length;i++) {
					System.out.print(output[i]+" ");
				}
				System.out.println();
				return;
			}
			else return;
		}
		else {
			for(int i=0;i<data.length;i++) {
				output[depth] = dice[i];
				samePermute(r, depth+1, data, output);
				output[depth] = 0;
			}
		}
	}

}
