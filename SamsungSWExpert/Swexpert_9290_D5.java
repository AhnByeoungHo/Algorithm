package bak20200205;

import java.util.Scanner;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 5.
 * @see	 https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9kLTqKcPkDFAUY
 * @mem
 * @time
 * @caution	Not Solved
 * 
 * */

public class Swexpert_9290_D5 {
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x +","+y;
		}
	}
	static int minLen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			Pair[] flowerList = new Pair[n];
			boolean[] visit = new boolean[n];
			Pair[] output = new Pair[k*2];

			for(int i=0;i<n;i++) {
				Pair p = new Pair(sc.nextInt(),sc.nextInt());
				flowerList[i] = p;
			}
			minLen = Integer.MAX_VALUE;
			dfs(k*2,flowerList, output,0,visit,k*2);
			
			flowerList = null;
			visit =  null;
			output =  null;
			if(minLen==Integer.MAX_VALUE) System.out.println("#"+tc+" NO");
			else System.out.println("#"+tc+" "+minLen);
		}

	}
	public static void dfs(int r,Pair[] flowerList, Pair[] output,int depth,boolean[] visit,int k) {
		if(r<(k/2) && r!=0) {

			Pair t =output[depth-1];
			int maxh=-1;
			int minh = 251;
			int maxw = -1;
			int minw = 251;
			for(int j=0;j<k/2;j++) {
				if(output[j].x > maxh) maxh = output[j].x;
				if(output[j].x < minh) minh = output[j].x;
				if(output[j].y > maxw) maxw = output[j].y;
				if(output[j].y < minw) minw = output[j].y;			
			}
			
			if(t.x<=maxh && t.x >=minh && t.y<=maxw && t.y >=minw) {

				System.out.println("r: "+r);
				for(int i=0;i<output.length;i++)
					System.out.println(output[i]);
				System.out.println();
				System.out.println(maxh +" "+minh+" " +maxw+" "+minw);
				System.out.println(t);
				System.out.println();
				return; 
			
			}
		}
		if(r==0) {
				int len = 0;
				
				int maxh=-1;
				int minh = 251;
				int maxw = -1;
				int minw = 251;
				for(int j=0;j<k/2;j++) {
					if(output[j].x > maxh) maxh = output[j].x;
					if(output[j].x < minh) minh = output[j].x;
					if(output[j].y > maxw) maxw = output[j].y;
					if(output[j].y < minw) minw = output[j].y;			
				}
				int maxh2=-1;
				int minh2 = 251;
				int maxw2 = -1;
				int minw2 = 251;
				for(int j=k/2+1;j<k;j++) {
					if(output[j].x > maxh2) maxh2 = output[j].x;
					if(output[j].x < minh2) minh2 = output[j].x;
					if(output[j].y > maxw2) maxw2 = output[j].y;
					if(output[j].y < minw2) minw2 = output[j].y;
				}
				//maxh maxw   maxh minw   minh maxw   minh minw
				boolean cant = false;
				
				int maxhtemp= maxh>maxh2?maxh:maxh2;
				int minhtemp = minh<minh2?minh:minh2;
				int maxwtemp = maxw>maxw2?maxw:maxw2;
				int minwtemp = minw<minw2?minw:minw2;
				if(maxhtemp-minhtemp>((maxh-minh)+(maxh2-minh2))) cant = true;
				if(maxwtemp-minwtemp>((maxw-minw)+(maxw2-minw2))) cant = true;
				
				if(!cant) {
					len = 2*(maxh-minh + 1) + 2*(maxw-minw + 1)
							+2*(maxh2-minh2 + 1) + 2*(maxw2-minw2 + 1);
					if(len<minLen) minLen = len;
				}
				else return;
		}
		else {
			for(int i=0;i<flowerList.length;i++) {
				if(!visit[i]) {
					visit[i] = true;
					output[depth] = flowerList[i];
					dfs(r-1, flowerList, output,depth+1,visit,k);
					output[depth] = new Pair(0,0);
					visit[i] = false;
				}
				
			}
		}
	}
	

}
