package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_6987 {
	 static int[] g1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	 static int[] g2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	 static boolean ans;
	private static Team[] teams;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 4; tc++) {
			ans = false;
			String line = br.readLine();
			teams = new Team[6];
			
			for (int i = 0; i < 6; i++) {
				teams[i] = new Team(line.charAt(i*6)-'0', line.charAt(i*6+2)-'0', line.charAt(i*6+4)-'0');
			}
			int wincount=0, losecount = 0, samecount=0;
			for (int i = 0; i < 6; i++) {
				wincount += teams[i].win;
				losecount += teams[i].lose;
				samecount += teams[i].same;
			}
			if((wincount+samecount+losecount)!=30) ans = false;
			else dfs(0);
			if(ans)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}	
	}
	static void dfs(int play){
		if(ans) return;
		if(play==15){
			ans = true;
			return;
		}
		Team t1 = teams[g1[play]];
		Team t2 = teams[g2[play]];
		
		if(t1.win>0 && t2.lose>0){
			t1.win--; t2.lose--;
			dfs(play+1);
			t1.win++; t2.lose++;
		}
		if(t1.lose>0 && t2.win>0){
			t1.lose--; t2.win--;
			dfs(play+1);
			t1.lose++; t2.win++;
		}
		if(t1.same>0 && t2.same>0){
			t1.same--; t2.same--;
			dfs(play+1);
			t1.same++; t2.same++;
		}
	}
	static class Team{
		int win;
		int same;
		int lose;
		public Team(int win, int same, int lose) {
			this.win = win;
			this.same = same;
			this.lose = lose;
		}
		@Override
		public String toString() {
			return "team [win=" + win + ", same=" + same + ", lose=" + lose + "]";
		}
		
	}
}
