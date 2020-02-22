package bak;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_14888 {

	private static int N;
	private static int[] num;
	private static int[] oper = {0,0,0,0};
	private static int MAX = Integer.MIN_VALUE;
	private static int MIN = Integer.MAX_VALUE;
	
	//+ - x /
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for(int i=0;i<N;i++){
			int n = sc.nextInt();
			 num[i] = n;
		}
		for(int i=0;i<4;i++){
			int n = sc.nextInt();
			oper[i] = n;
		}
		//System.out.println(Arrays.toString(oper));
		dfs(0,num[0]);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	private static void dfs(int depth,int result) {
		if(depth==N-1){
			//System.out.println(result);
			MAX = Integer.max(result, MAX);
			MIN = Integer.min(result, MIN);
			return;
			
		}else{
			for(int i=0;i<4;i++){
				if(oper[i]>0){
					oper[i] -= 1;
					if(i==0){
						dfs(depth+1, result + num[depth+1]);
					}else if(i==1){
						dfs(depth+1, result - num[depth+1]);
					}else if(i==2){
						dfs(depth+1, result * num[depth+1]);
					}else if(i==3){
						dfs(depth+1, result / num[depth+1]);
					}
					oper[i] += 1;
					
				}
			}
		}
		
	}
	

}
