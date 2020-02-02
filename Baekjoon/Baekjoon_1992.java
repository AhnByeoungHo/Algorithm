package bak;

import java.util.Scanner;

public class Baekjoon_1992 {

	static int[][] map;
	static int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++){
			String str = sc.next();
			for(int j=0;j<N;j++){
				map[i][j] = str.charAt(j)-'0';
			}
		}
		quadTree(0, 0, N);
		
	}
	private static boolean check(int row, int col, int n) {
        int std = map[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != map[i][j]) {
                    return false;
                }
            }
        }
        m = std;
        return true;
    }
 
    private static void quadTree(int row, int col, int n) {
        if (check(row, col, n)) {
            System.out.print(m);
        } else {
            System.out.print("(");
            int s = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    quadTree(row + s * i, col + s * j, s);
                }
            }
            System.out.print(")");
        }
    }

}
