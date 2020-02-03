package work20200203;

import java.util.Arrays;

public class N_queens {

	static int size = 4;
	static int[][] chess = new int[size][size];
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) {
		dfs(0);
	}
	public static boolean isPromising() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(chess[i][j]==1) {
					for(int k=0;k<j;k++) {
						if(chess[i][k]==1) return false;				//왼
					}
					for(int k=1;k<=i;k++) {
						if(chess[i-k][j]==1) return false; 				//위
						if(j-k>=0 && chess[i-k][j-k]==1) return false;	//왼대각
						if(j+k<size && chess[i-k][j+k]==1) return false;	//오른대각
					}
					
				}
			}
		}
		return true;
	}
	public static void dfs(int r) {
		if(r==size) {
			if(isPromising()) {
				for(int[] line: chess)
					System.out.println(Arrays.toString(line));
				System.out.println("==============");
			}
			
			return;
		}
		else {
			for(int i=0;i<size;i++) {
				chess[r][i] = 1;
				dfs(r+1);
				chess[r][i] = 0;
			}
		}
	}
	

}
