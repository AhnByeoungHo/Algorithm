package bak20200213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Swexpert_1258_D4 {

	private static int N;
	private static int[][] map;
	private static int[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			ArrayList<Pair> pa = new ArrayList<>();
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j*2)-'0';
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(map[i][j]!=0 && visit[i][j]==0) {
						int curx = i;
						int cury = j;
						//left
						while(true) {
							int nx = curx;
							int ny = cury+1;
							if(ny>=N) break;
							if(map[nx][ny]==0)break;
							curx = nx;
							cury = ny;
						}
						//down
						while(true) {
							int nx = curx+1;
							int ny = cury;
							if(nx>=N) break;
							if(map[nx][ny]==0)break;
							curx = nx;
							cury = ny;
						}
						
						for(int a=i;a<=curx;a++) {
							for(int b=j;b<=cury;b++) {
								visit[a][b] = 1;
							}
						}

						pa.add(new Pair(curx-i,cury-j,(curx-i+1)*(cury-j+1)));
					}
				}
			}
			pa.sort(new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					// TODO Auto-generated method stub
					Integer area1 = o1.area;
					Integer area2 = o2.area;
					if(!area1.equals(area2))
						return area1.compareTo(area2);
					Integer hang1 = o1.x;
					Integer hang2 = o2.x;
					return hang1.compareTo(hang2);
				}
			});
			
			System.out.print("#"+tc+" "+pa.size()+ " ");
			for(int i=0;i<pa.size();i++) {
				System.out.print((pa.get(i).x+1)+" " +(pa.get(i).y+1)+" ");
			}
			System.out.println();
			
		}

	}
	
	static class Pair{
		int x;
		int y;
		int area;
		Pair(int x,int y,int area) {
			this.x=x;
			this.y=y;
			this.area = area;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+ ","+ y+ " : "+ area;
		}
	}

}
