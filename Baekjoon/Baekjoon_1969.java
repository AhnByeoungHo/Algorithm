package bak20200130;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1969 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int linenum = sc.nextInt();
		int len = sc.nextInt();
		
		char[][] map = new char[linenum][len];
		
		for(int i=0;i<linenum;i++) {
			String str = sc.next();
			for(int j=0;j<len;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		char[] output = new char[len];
		int hDistance = 0;
		for(int i=0;i<len;i++) {
			int[] countACGT = {0,0,0,0};
			for(int j=0;j<linenum;j++) {
				if(map[j][i]=='A') countACGT[0]++;
				else if(map[j][i]=='C') countACGT[1]++;
				else if(map[j][i]=='G') countACGT[2]++;
				else if(map[j][i]=='T') countACGT[3]++;
			}
			int max = 0;
			int linedistance = 0;
			for(int a=0;a<4;a++) {
				if(countACGT[a]>max) {
					max = countACGT[a];
				}
				linedistance += countACGT[a];
			}
			int maxidx=0;
			for(int a=0;a<4;a++) {
				if(countACGT[a]==max) {
					maxidx = a;
					break;
				}
			}
			if(maxidx==0) {
				output[i] = 'A';
				linedistance -= countACGT[0];
			}
			else if(maxidx==1) {
				output[i] = 'C';
				linedistance -= countACGT[1];
			}
			else if(maxidx==2) {
				output[i] = 'G';
				linedistance -= countACGT[2];
			}
			else if(maxidx==3) {
				output[i] = 'T';
				linedistance -= countACGT[3];
			}
			hDistance += linedistance;
		}
		for(int i=0;i<len;i++) {
			System.out.print(output[i]);
		}
		System.out.println();
		System.out.println(hDistance);
	}

}
