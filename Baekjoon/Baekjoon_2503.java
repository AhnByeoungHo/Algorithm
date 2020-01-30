package bak20200130;

import java.util.Arrays;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Baekjoon_2503 {
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9};
		Scanner sc = new Scanner(System.in);
		
		int[] output = new int[3];
		
		int N = sc.nextInt();
		int[][] say = new int[N][3];
		int[][] sb = new int[N][2];
		for(int i=0;i<N;i++) {
			String str = sc.next();
			int temp = Integer.parseInt(str);

			for(int j=2;j>=0;j--) {
				say[i][j] = temp%10;
				temp/=10;
			}
			int strike = sc.nextInt();
			int ball = sc.nextInt();
			sb[i][0] = strike;
			sb[i][1] = ball;

		}

		
		
		permute(0, num, output, say, sb);
		System.out.println(count);
		
	}
	public static void permute(int depth,int[] num, int[] output,int[][] say,int[][] sb) {
		if(depth==3) {
			if(output[0]!=output[2]&&output[1]!=output[2]&&output[1]!=output[0]) {
				int right=0;
				for(int i=0;i<say.length;i++) {
					int strike=0;
					int ball=0;
					for(int j=0;j<3;j++) {
						if(output[j]==say[i][j]) strike++;
					}
					for(int c=0;c<3;c++) {
						for(int j=0;j<3;j++) {
						if(output[c]==say[i][j]&&c!=j) ball++;
						}
					}
					if(strike == sb[i][0]&&ball==sb[i][1]) {
						right++;
					}
//					System.out.println("output: " + Arrays.toString(output) + 
//							"sb: " + Arrays.toString(say[i]) +
//							"s:"+strike+" b:"+ball);
				}
				
				if(right==say.length) {
					count++;
					return;
				}else {
					return;
				}
			}
			else return;
			
		}
		else {
			for(int i=0;i<num.length;i++) {
				output[depth]=num[i];
				permute(depth+1, num, output, say, sb);
			}
		}
	}

}
