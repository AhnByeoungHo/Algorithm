package work20200122;

import java.util.Scanner;

public class Swexpert_1210_D4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int t=1;t<=10;t++) {
			sc.nextInt();
			int [][]ladder = new int[100][100];
			
			for(int i=0;i<100;i++)
				for(int j=0;j<100;j++) {
					ladder[i][j] = sc.nextInt();
				}
			int []dx = {0,0,1};
			int []dy = {1,-1,0};
 			for(int i=0;i<100;i++) {
				if(ladder[0][i]==1) {
					int [][]visited = new int[100][100];
					int cury = i;
					int curx = 0;
					while(curx!=99) {
						for(int dir = 0;dir<3;dir++) {
							int nx = curx+dx[dir];
							int ny = cury+dy[dir];
							if(nx<0||ny<0||nx>=100||ny>=100) continue;
							if(ladder[nx][ny]==0 || visited[nx][ny]==1) continue;
							//System.out.println(curx+" "+cury);
							visited[nx][ny] = 1;
							curx = nx;
							cury = ny;
							break;
						} 
					}
					if(ladder[curx][cury]==2) {
						System.out.println("#"+t+" "+i);
						break;
					}
				}
			}
		}
	}

}
