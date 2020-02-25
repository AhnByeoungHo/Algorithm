package bak;

import java.util.Scanner;

public class Baekjoon_5014 {

	private static int down;
	private static int up;
	private static int destination;
	private static int start;
	private static int totalFloor;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		totalFloor = sc.nextInt();
		start = sc.nextInt();
		destination = sc.nextInt();
		up = sc.nextInt();
		down = sc.nextInt();
		visit = new boolean[totalFloor+1];
		visit[start] = true;
		dfs(start,0);

		if(MIN==Integer.MAX_VALUE)
			System.out.println("use the stairs");
		else System.out.println(MIN);
	}

	private static void dfs(int cur, int bCount) {
		//System.out.println(cur);
		if(cur>totalFloor) return;
		if(cur==destination){
			MIN = Math.min(MIN, bCount);
			return;
		}
		else{

			if(start<=destination){
				if(cur<=totalFloor-up){
					if(!visit[cur+up]){
						visit[cur+up] = true;
						dfs(cur+up,bCount+1);
						//visit[cur+up] = false;
					}
				}
				if(cur>down){
					if(!visit[cur-down]){
						visit[cur-down] = true;
						dfs(cur-down,bCount+1); 
						//visit[cur-down] = false;
					}
					
				}
			}
			else{
				if(cur>down){
					if(!visit[cur-down]){
						visit[cur-down] = true;
						dfs(cur-down,bCount+1); 
						//visit[cur-down] = false;
					}
				}
				if(cur<=totalFloor-up){
					if(!visit[cur+up]){
						visit[cur+up] = true;
						dfs(cur+up,bCount+1);
						//visit[cur+up] = false;
					}
				}
			}
		}
	}

}
