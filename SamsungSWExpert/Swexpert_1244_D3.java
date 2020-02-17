package bak20200217;

import java.util.Arrays;
import java.util.Scanner;

public class Swexpert_1244_D3 {

	private static int MAX = Integer.MIN_VALUE;
	private static int change;
	private static String num;
	private static char[] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			num = sc.next();
			change = sc.nextInt();
			temp = num.toCharArray();
			MAX = Integer.MIN_VALUE;
			if(change >= temp.length) {
				change = temp.length;
			}
			dfs(0, new int[2],0,0);
			System.out.println("#"+tc+" "+MAX);

		}

	}
	public static void dfs(int depth,int[] output,int start,int c) {
		if(change==c) {
			int total = 0;
			for(int i=temp.length-1;i>=0;i--) {
				total += (temp[i]-'0')*Math.pow(10, temp.length-1-i);
			}
			if(MAX<total) MAX=total;
			return;
		}
		else if(depth==2) {
			char t= temp[output[0]];
			temp[output[0]] = temp[output[1]];
			temp[output[1]] = t;

			dfs(0, new int[2], 0, c+1);

			t= temp[output[0]];
			temp[output[0]] = temp[output[1]];
			temp[output[1]] = t;
			return;
		}
		else {
			
			for(int i=start;i<num.length();i++) {
				output[depth] = i;
				dfs(depth+1, output,i+1,c);
			}

		}
	}

}
