package bak20200220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1919 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] countA = new int[26];
		int[] countB = new int[26];
		
		String lineA = br.readLine();
		for(int i=0;i<lineA.length();i++)
			countA[lineA.charAt(i)-'a']++;
		String lineB = br.readLine();
		for(int i=0;i<lineB.length();i++)
			countB[lineB.charAt(i)-'a']++;
		
		int result=0;
		for(int i=0;i<26;i++) {
			if(countA[i]>countB[i]) result+= countA[i]-countB[i];
			else if(countA[i]<countB[i]) result+= countB[i]-countA[i];
		}
		System.out.println(result);
	}

}
