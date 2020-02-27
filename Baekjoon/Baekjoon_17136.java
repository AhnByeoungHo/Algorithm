package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_17136{

	private static int[][] map;
	private static int[][] copy;
	private static int MIN = Integer.MAX_VALUE;
	private static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		copy = new int[10][10];
		visit = new int[5][6];
		for(int i=0;i<10;i++){
			String line = br.readLine();
			for(int j=0;j<10;j++){
				map[i][j] = line.charAt(j*2)-'0';
				copy[i][j] = map[i][j];
			}
		}

		int[] arr = {5,5,5,5,5};
		dfs(arr,0);
		if(MIN==Integer.MAX_VALUE)
			MIN=-1;
		System.out.println(MIN);
	}

	public static void dfs(int[] paper,int result){


		if(MIN<result)
			return;

//		System.out.println(Arrays.toString(paper));
//		for(int i=0;i<10;i++)
//			System.out.println(Arrays.toString(copy[i]));
		boolean can = true;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(copy[i][j]==1)
				{
					can = false;
					break;
				}
			}
		}
		if(can){
			MIN = Math.min(MIN, result);

		}
		else{
			for(int i=4;i>=0;i--){
				if(paper[i]==0) continue;
				int px = 0;
				int py = 0;
				boolean end= false;

				for(int a=0;a<10;a++){
					for(int b=0;b<10;b++){
						if(copy[a][b]==1)
						{
							px = a;
							py = b;
							end = true;
							break;
						}
					}if(end) break;
				}
				if(px+i+1>10||py+i+1>10) continue;
				if(px==0&&py==0&&copy[0][0]==0) continue;

				end = false;
				for(int a=px;a<px+i+1;a++){
					for(int b=py;b<py+i+1;b++){
						if(copy[a][b]==0)
						{
							end = true;
							break;
						}
					}
					if(end) break;
				}
				if(!end){
					for(int a=px;a<px+i+1;a++){
						for(int b=py;b<py+i+1;b++){
							copy[a][b] = 0;
						}
					}
					paper[i]--;
					
					dfs(paper,result+1);
					paper[i]++;
					for(int a=px;a<px+i+1;a++){
						for(int b=py;b<py+i+1;b++){
							copy[a][b] = map[a][b];
						}
					}
				}
				
			}

		}
	}
}
//notsolve
/*public class Baekjoon_17136 {

	private static int[][] map;
	private static int MIN = Integer.MAX_VALUE;
	private static int[][] copy = new int[10][10];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		for(int i=0;i<10;i++){
			String line = br.readLine();
			for(int j=0;j<10;j++){
				map[i][j] = line.charAt(j*2)-'0';
			}
		}
		//dfs(new int[5],0);
		for(int count=0;count<16;count++){
			if(count==15) {
				System.out.println(-1);
				System.exit(0);
			}
			for (int a = 0; a < 6; a++) {
				if(a>count||29-(5-a)<count)break;
				for (int b = 0; b < 6; b++) {
					if(a+b>count||29-(10-a-b)<count)break;
					for (int c = 0; c < 6; c++) {
						if(a+b+c>count||29-(15-a-b-c)<count) break;
						for (int d = 0; d < 6; d++) {
							if(a+b+c+d>count||29-(20-a-b-c-d)<count)break;
							for (int e = 0; e < 5; e++) {
								int len = a+b+c+d+e;

								if(len==count){
									int[] temp = {a,b,c,d,e};
									int[] p = new int[5];
									for(int i=0;i<5;i++){
										p[i] = temp[i];
									}
									permute(p,new int[len],0,len);


								}

							}
						}
					}
				}
			}
		}




	}
	private static void permute(int[] p, int[] output ,int depth, int len) {


		if(depth==len){
			int[] temp = new int[len];
			for(int i=0;i<len;i++)
				temp[i] = output[i];
			for(int i=0;i<10;i++){
				for(int j=0;j<10;j++){
					copy[i][j] = map[i][j];
				}
			}
			int result = can(temp);
			if(result>-1){
				//System.out.println(Arrays.toString(temp));
				MIN  = Math.min(MIN,result);
				System.out.println(MIN);
				System.exit(0);
			}
			return;
		}

		else{
			for(int i=0;i<p.length;i++){
				if(p[i]>0){
					p[i]--;
					output[depth] = i;
					permute(p, output, depth+1, len);
					p[i]++;
				}
			}
		}
	}
	private static int can(int[] temp) {

		int result=temp.length;
		if(result>MIN) return -1;

		for(int i=0;i<temp.length;i++){
			boolean can = false;
			int point = temp[i]+1;

			for(int x=0;x<10;x++){
				for(int y=0;y<10;y++){
					if(copy[x][y]==1){
						if(x>10-point||y>10-point) continue;
						if(x>10-point&&y>10-point){
							can = false;
							break;
						}
						for(int a=x;a<x+point;a++){
							for(int b=y;b<y+point;b++){
								if(copy[a][b]==0){
									can = false;
									break;
								}else
									can=true;
							}
							if(!can) break;
						}
						if(can){
							for(int a=x;a<x+point;a++){
								for(int b=y;b<y+point;b++){
									copy[a][b] = 0;
								}
							}
							break;
						}
					}
				}
				if(can)break;
			}

			if(!can) return -1;
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(copy[i][j]==1){
					return -1;
				}
			}
		}
		return result;
	}
}
 */