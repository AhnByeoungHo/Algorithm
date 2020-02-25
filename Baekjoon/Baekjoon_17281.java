package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_17281 {

	private static int N;
	private static int[][] person;
	private static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		person = new int[N][9];
		for(int i=0;i<N;i++){
			String line = br.readLine();
			for(int j=0;j<9;j++){
				person[i][j] = line.charAt(j*2)-'0';
			}
		}
		permutePerson(0, new int[9], new boolean[9]);
		System.out.println(MAX);
	}
	static void permutePerson(int depth, int[] output,boolean[] visit){
		if(depth==4){
			if(output[3] != 1) return;
		}
		if(depth==9){
			int[][] temp = new int[N][9];
			for(int i=0;i<N;i++){
				for(int j=0;j<9;j++){
					temp[i][j] = person[i][output[j]-1];
				}
			}
			play(temp);
			return;
		}
		else{
			for(int i=0;i<9;i++){
				if(!visit[i]){
					output[depth] = i+1;
					visit[i] = true;
					permutePerson(depth+1, output, visit);
					visit[i] = false;
				}
			}
		}
	}
	private static void play(int[][] temp) {

		int player = 0;
		int score = 0;

		for(int i=0;i<N;i++){
			boolean[] base = new boolean[4];
			int outcount = 0;
			while(true){
				if(outcount==3) break;
				int current = temp[i][player];
				if(current==1){
					if(base[3]){
						score++;
						base[3] = false;
					}

					for(int b=3;b>=2;b--){
						if(base[b-1]){
							base[b] = true;
							base[b-1] = false;
						}
					}
					base[1] = true;
					base[0] = false;
					player = (player+1)%9;
				}else if(current==2){
					for(int b=3;b>=2;b--){
						if(base[b]) score++;
					}
					if(base[1]) base[3] = true;
					else base[3] = false;
					base[2] = true;
					base[1] = false;
					base[0] = false;
					player = (player+1)%9;
				}else if(current==3){
					for(int b=3;b>=1;b--){
						if(base[b]) score++;
					}
					base[3] = true;
					base[2] = false;
					base[1]  =false;
					base[0] = false;
					player = (player+1)%9;
				}else if(current==4){
					base[0]= true;
					for(int s=0;s<4;s++){
						if(base[s]) {
							score++;
							base[s] = false;
						}
					}
					player = (player+1)%9;
				}else if(current==0){
					outcount++;
					player = (player+1)%9;
				}

			}
		}

		MAX  = Math.max(MAX, score);

	}
}

