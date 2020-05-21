package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1062 {
	static boolean[] visit = new boolean[26];
	private static int K;
	private static String[] arr;
	private static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		visit['a'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		visit['i'-'a'] = true;
		visit['c'-'a'] = true;
		
		ans = 0;
		if(K<5) {
			ans = 0;
		} else {
			combi(0, 0);
		}
		System.out.println(ans);
	}
	static void combi(int depth, int start){
		if(depth==K-5){
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				boolean isok = true;
				for (int j = 4; j < arr[i].length(); j++) {
					if(!visit[arr[i].charAt(j)-'a']){
						isok = false;
						break;
					}
				}
				if(isok){
					count++;
				}
			}
			ans = Math.max(ans, count);
			return;
		}
		for (int i = start; i < visit.length; i++) {
			if(!visit[i]){
				visit[i] = true;
				combi(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
}
