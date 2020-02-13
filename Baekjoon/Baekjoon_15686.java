package bak20200213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon_15686 {

	private static int N;
	private static int M;
	private static int[][] map;
	static ArrayList<Pair> chiList;
	private static ArrayList<int[]> chooseList;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chiList = new ArrayList<>();
		map = new int[N][N];

		//0 empty 1 house 2 chicken
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = line.charAt(j*2)-'0';
				if(map[i][j]==2) chiList.add(new Pair(i,j));
			}
		}

		Queue<Pair> houseList = new LinkedList<>();
		int[] output = new int[M];

		chooseList = new ArrayList<int[]>();
		combi(0,M,output,0);

		int max = Integer.MAX_VALUE;
		int oneCount = 0;
		for(int i=0;i<chooseList.size();i++) {
			//M개 고르기
			for(int a=0;a<N;a++) {
				for(int j=0;j<N;j++) {
					if(map[a][j]==2) {
						map[a][j] = 0;
					}
					if(map[a][j]==1) {
						oneCount++;
					}
				}
			}
			for(int a=0;a<chooseList.get(i).length;a++) {
				Pair p = chiList.get(chooseList.get(i)[a]);
				map[p.x][p.y]=2;
			}

			//집일떄 확산
			int[][] visit= new int[N][N];
			int total = 0;
			for(int a=0;a<N;a++) {
				for(int j=0;j<N;j++) {
					if(map[a][j]==2) {
						houseList.offer(new Pair(a,j));
						visit[a][j] = 1;
					}

				}
			}
			int sum=0;
			int c=0;
			while(!houseList.isEmpty()) {
				Pair p = houseList.poll();
				int curx = p.x;
				int cury = p.y;
				if(map[curx][cury]==1) {
					sum+=visit[curx][cury]-1;
					c++;
				}
				if(c==oneCount) {
					break;
				}
				for(int dir=0;dir<4;dir++) {
					int nx = curx+dx[dir];
					int ny = cury+dy[dir];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(visit[nx][ny]!=0) continue;
					houseList.offer(new Pair(nx,ny));
					visit[nx][ny] = visit[curx][cury]+1;
				}
			}

//			for(int s=0;s<N;s++)
//				System.out.println(Arrays.toString(visit[s]));
//			System.out.println();
			if(max>sum) {
				max = sum;
			}
			houseList.clear();
		}
		System.out.println(max);


	}
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static void combi(int depth, int r,int[] output, int start) {
		if(depth==r) {
			int[] temp = new int[output.length];
			for(int i=0;i<temp.length;i++)
				temp[i] = output[i];
			chooseList.add(temp);
			return;
		}
		else {
			for(int i=start;i<chiList.size();i++) {
				output[depth] = i;
				combi(depth+1, r, output, i+1);
			}
		}
	}
}
