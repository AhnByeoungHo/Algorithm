package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15684 {

	private static int N;
	private static int M;
	private static int H;
	private static int[][] map;
	private static ArrayList<leg> legarr;
	private static int c;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N];
		c = 1;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = c;
			map[y][x+1] = c++;
		}
		//
		//		for(int i=0;i<H;i++){
		//			System.out.println(Arrays.toString(map[i]));
		//		}
		//		System.out.println(test(map));
		if(M==0) {
			System.out.println("0");
			System.exit(0);
		}
		else if(test(map)){
			System.out.println("0");
			System.exit(0);
		}
		else{
			legarr = new ArrayList<>();
			for(int i=0;i<H;i++){
				for(int j=0;j<N-1;j++){
					if(map[i][j]==0&&map[i][j+1]==0){
						legarr.add(new leg(i,j));
					}
				}
			}
			for(int i=1;i<4;i++){
				//System.out.println("----"+i+"----");
				dfs(0,i,new int[i],0);
			}
			System.out.println(-1);
		}



	}
	private static void dfs(int depth, int r, int[] output, int start) {
		// TODO Auto-generated method stub
		if(depth==r){
			int[][] copy = new int[H][N];
			for(int i=0;i<H;i++){
				for(int j=0;j<N;j++){
					copy[i][j] = map[i][j];
				}
			}
			int a=0;
			for(int i=0;i<output.length;i++){
				int x = legarr.get(output[i]).x;
				int y = legarr.get(output[i]).y;
				if(copy[x][y]==0){
					copy[x][y] = c;
					copy[x][y+1] = c++;
					a++;
				}
				
			}
			//System.out.println("######");
//			if(depth==3){
//				for(int i=0;i<H;i++){
//					System.out.println(Arrays.toString(copy[i]));
//				}
//				System.out.println();
//			}
//			System.out.println("______");
			if(test(copy)){

				//				for(int i=0;i<H;i++){
				//					System.out.println(Arrays.toString(copy[i]));
				//				}
				System.out.println(depth);
				System.exit(0);
			}
			c = c - a;
			return;
		}
		else{
			for(int i=start;i<legarr.size();i++){
				output[depth] = i;
				dfs(depth+1, r, output, i+1);
			}
		}
	}
	static boolean test(int[][] m){
		for(int i=0;i<N;i++){
			int curx=0;
			int cury=i;

			while(curx<H){
				//System.out.println(curx+" "+cury);
				if(m[curx][cury]!=0){
					if(cury!=0&&cury!=N-1){
						int ny1 = cury+1;
						int ny2 = cury-1;
						if(m[curx][ny1]==m[curx][cury]){
							cury = ny1;
						}
						else if(m[curx][ny2]==m[curx][cury]){
							cury = ny2; 
						}
						if(curx==H-1&&cury!=i) return false;
						curx = curx + 1;
						//if(curx==H-1&&cury!=i) return false;
					}
					else if(cury==0){
						int ny = cury + 1;
						if(curx==H-1 && ny!=i) return false;
						curx = curx+1;
						cury = ny;
						//if(curx==H-1&&cury!=i) return false;
					}
					else if(cury==N-1){
						int ny = cury - 1;
						if(curx==H-1 && ny!=i) return false;
						curx = curx+1;
						cury = ny;
						//if(curx==H-1&&cury!=i) return false;
					}
				}
				else
				{
					int nx = curx + 1;
					if(nx==H) {
						if(i!=cury) 
							return false;
					}
					curx = nx;
				}


			}
			
			if(curx==H&&cury!=i) return false;
//			System.out.println(curx+" "+cury);
//			System.out.println("------");
		}

		return true;
	}
	static class leg{
		int x;
		int y;
		public leg(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
