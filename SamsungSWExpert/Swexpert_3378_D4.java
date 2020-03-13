package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swexpert_3378_D4 {

	private static int[][] m;
	private static int[][] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken()); //마스터의 코드줄수
			int q = Integer.parseInt(st.nextToken()); //나의 코드줄수

			m = new int[p][4];// . 소 중 대

			for (int i = 0; i < p; i++) {
				String line = br.readLine();
				//.의개수
				int index = 0;
				while(line.charAt(index)=='.'){
					index++;
				}
				m[i][0] = index;

				//괄호의 개수는 누적처리
				if(i>0){
					m[i][1] = m[i-1][1];
					m[i][2] = m[i-1][2];
					m[i][3] = m[i-1][3];
				}
				for (int j = index; j < line.length(); j++) {
					char c = line.charAt(j);
					switch (c) {
					case '(':
						m[i][1]++;
						break;
					case ')':
						m[i][1]--;
						break;
					case '{':
						m[i][2]++;
						break;
					case '}':
						m[i][2]--;
						break;
					case '[':
						m[i][3]++;
						break;
					case ']':
						m[i][3]--;
						break;
					}
				}

			}//마스터의 스타일리쉬 코드분석 for
			
			
			ans = new int[q][4];// . 소 중 대

			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0;
				//괄호의 개수는 누적처리
				if(i>0){
					ans[i][1] = ans[i-1][1];
					ans[i][2] = ans[i-1][2];
					ans[i][3] = ans[i-1][3];
				}
				for (int j = index; j < line.length(); j++) {
					char c = line.charAt(j);
					switch (c) {
					case '(':
						ans[i][1]++;
						break;
					case ')':
						ans[i][1]--;
						break;
					case '{':
						ans[i][2]++;
						break;
					case '}':
						ans[i][2]--;
						break;
					case '[':
						ans[i][3]++;
						break;
					case ']':
						ans[i][3]--;
						break;
					}
				}

			}//나의 스타일리쉬 코드분석 for
			
			//ans[i][0] : . 의개수 -> 초기값-1
			for (int i = 0; i < q; i++) {
				ans[i][0] = -2;
			}
			//중복순열
			for (int R = 1; R < 21; R++) {
				for (int C = 1; C < 21; C++) {
					for (int S = 1; S < 21; S++) {
						if(check(R,C,S)){ //마스터코드의 해가되는가
							cal(R,C,S);
						}
					}
				}
			}
			sb.append("#").append(tc).append(" 0");
			for (int i = 1; i < ans.length; i++) {
				sb.append(' ').append(ans[i][0]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void cal(int R, int C, int S) {
		for (int i = 1; i < ans.length; i++) {
			int x = ans[i-1][1]*R + ans[i-1][2]*C + ans[i-1][3]*S;
			if(ans[i][0] == -2){
				ans[i][0] = x;
			}
			else if(ans[i][0] != x){
				ans[i][0] = -1;
			}
		}
	}

	private static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if(m[i][0] != m[i-1][1]*R + m[i-1][2]*C + m[i-1][3]*S){
				return false;
			}
		}
		
		return true;
	}

}
