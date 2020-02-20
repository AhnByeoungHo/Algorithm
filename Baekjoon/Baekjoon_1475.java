package bak20200220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1475 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] count = new int[9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		for(int i=0;i<line.length();i++) {
			int k = line.charAt(i)-'0';
			if(k==6||k==9)
				count[6]++;
			else count[k] +=2;
		}
		int max = 0;
		for(int i=0;i<9;i++) {
			max = Math.max(max, count[i]);
		}
		if(max%2==0)
			System.out.println(max/2);
		else
			System.out.println(max/2+1);
		//System.out.println(Arrays.toString(count));
	}

}
