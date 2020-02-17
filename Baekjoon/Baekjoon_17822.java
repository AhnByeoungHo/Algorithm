package bak20200217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17822 {

	private static int[][] map;
	private static int M;
	private static int N;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			todo(x,d,k);
		}
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				ans+=map[i][j];
			}
		}
//		for(int i=0;i<N;i++)
//			System.out.println(Arrays.toString(map[i]));
		System.out.println(ans);

	}

	private static void todo(int x, int d, int k) {
		// TODO Auto-generated method stub


		for(int a=x-1;a<N;a+=x) {
			int[] nline = new int[M];


			if(d==0) {
				for(int i=0;i<M;i++) {
					nline[i] = map[a][(M+i-k)%M];
				}
				for(int i=0;i<M;i++) {
					map[a][i]=nline[i];
				}
			}
			else if(d==1) {
				for(int i=0;i<M;i++) {
					nline[i] = map[a][(i+k)%M];
				}
				for(int i=0;i<M;i++) {
					map[a][i]=nline[i];
				}
			}




		}
//		for(int t=0;t<N;t++)
//			System.out.println(Arrays.toString(map[t]));
//		System.out.println();

		
		int count=0;
		int[][] copy = new int[N][M];
		for(int b=0;b<N;b++) {
			for(int a=0;a<M;a++) {
				copy[b][a] = map[b][a];
			}
		}
		for(int j=0;j<N;j++) {
			for(int i=0;i<M;i++) {	
				
				if(map[j][i]!=0) {
					for(int dir=0;dir<4;dir++) {
						int nx = (N + j + dx[dir])%N;
						int ny = (M + i + dy[dir])%M;
						if(nx<0||nx>=N) continue;
						if(((nx==N-1&&j==0) || (j==N-1&&nx==0))&& N!=2) continue;
						if(map[j][i]==map[nx][ny]&&map[j][i]!=0) {
							copy[j][i] = 0;
							count++;
						}
					}	
				}
				
			}
		}
		for(int b=0;b<N;b++) {
			for(int a=0;a<M;a++) {
				map[b][a] = copy[b][a];
			}
		}
		
		
		
		if(count==0) {
			double s =0;
			double todiv=0;
			for(int a=0;a<N;a++) {
				for(int b=0;b<M;b++) {
					if(map[a][b]!=0) {
						s+=map[a][b];
						todiv++;
					}	
				}
			}
			double avg = s/todiv;
//			System.out.println(avg);
			for(int a=0;a<N;a++) {
				for(int b=0;b<M;b++) {
					if((double)map[a][b]<avg&&map[a][b]!=0) {
						map[a][b]++;
					}
					else if((double)map[a][b]>avg&&map[a][b]!=0) {
						map[a][b] = map[a][b] -1;
					}	
					
				}
			}

		}


	}

}
