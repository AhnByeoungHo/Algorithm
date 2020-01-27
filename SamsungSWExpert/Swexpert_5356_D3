package work20200122;

import java.util.Scanner;

public class Swexpert_5356_D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			
			char [][]map = new char[5][15];
			for(int i=0;i<5;i++) {
				String str = sc.next();
				for(int j=0;j<str.length();j++) {
					map[i][j] = str.charAt(j);
				}
				for(int j=str.length();j<15;j++) {
					map[i][j]=' ';
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<15;i++) {
				for(int j=0;j<5;j++) {
					if(map[j][i] == ' ')
						continue;
					else 
						System.out.print(map[j][i]);
				}
			}
			System.out.println();
			
			
		}
	}

}
