package bak20200218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_11728 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder("");
		int aLen = Integer.parseInt(st.nextToken());
		int bLen = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> a = new LinkedList<>();
		LinkedList<Integer> b = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<aLen;i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<bLen;i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}

		
		
		while(true) {
			if(a.isEmpty()&&b.isEmpty()) break;
			if(b.isEmpty()) {
				sb.append(a.get(0)).append(" ");
				a.remove(0);
				continue;
			}
			if(a.isEmpty()) {
				sb.append(b.get(0)).append(" ");
				b.remove(0);
				continue;
			}
			{
				if(a.get(0)<b.get(0)) {
					sb.append(a.get(0)).append(" ");
					a.remove(0);
				}
				else {
					sb.append(b.get(0)).append(" ");
					b.remove(0);
				}
			}
		}
		System.out.println(sb);
		
	}

}
