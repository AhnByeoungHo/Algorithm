package work20200122;

import java.util.Scanner;

public class swexpert_1954_D2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][]map = new int[N][N];
		int count = 1;
		int x=0,y = 0;
		int max = N;
		while(count != N*N) {
			int curx = x++;
			int cury = y++;
			while(cury!=max-1) {
				if(count==N*N) break;
				if(map[curx][cury]==0) {
					map[curx][cury] = count++;
					int ny = cury + 1;
					cury = ny;
				}
				else break;
				
			}
			while(curx!=max-1) {
				if(count==N*N) break;
				if(map[curx][cury]==0) {
					map[curx][cury] = count++;
					int nx = curx + 1;
					curx = nx;
				}
				else break;
				
			}
			while(cury!=y-1) {
				if(count==N*N) break;
				if(map[curx][cury]==0) {
					map[curx][cury] = count++;
					int ny = cury - 1;
					cury = ny;
				}
				else break;
				
				
			}
			while(curx!=x-1) {
				if(count==N*N) break;
				if(map[curx][cury]==0) {
					map[curx][cury] = count++;
				int nx = curx - 1;
				curx = nx;
				}
				else break;
			}
			max--;
		}
		
		if(N%2==0)
			map[N/2][N/2-1] = N*N;
		else
			map[N/2][N/2] = N*N;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
