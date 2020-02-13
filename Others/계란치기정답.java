import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 입력방법: Scanner -> bufferedreader
 * 쪼개는방법 : String.split() -> StringTokenizer(br.readLine()," ")
 * 안쪼개는경우가 더좋음 charAt
 * 
 * 출력방법
 * String -> stringbuffer -> stringbuilder
 *  
 */
public class 계란치기정답 {

	private static int N;
	private static int[] s;
	private static int[] w;
	private static int maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); //1<=N<=8
		
		s = new int[N];
		w = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			s[i] = Integer.parseInt(st.nextToken());	//s<=300
			w[i] = Integer.parseInt(st.nextToken());	//w<=300
		}
		maxCnt = 0;
		dfs(0, 0);
		System.out.println(maxCnt);
	}
	
	/*index 번째의 계란을 들어서 깨지지 않는 계란을 타격한다 , cnt: 깨진계란수*/
	private static void dfs(int index, int cnt) {
		
		if(cnt>=N-1 || index == N) {	// 종료파트	남은계란이 1~0개일 경우 마지막계란일경우
			if(cnt>maxCnt) maxCnt = cnt;
			return;
		}
		if(s[index] <= 0){	//index번째 계란 깨지면 진행불가
			dfs(index+1,cnt);
			return;
		}
		{			//재귀파트
			for (int i = 0; i < N; i++) {
				if(index==i) continue;	//자기계란을 자기를 깰수 없음
				if(s[i]<=0) continue;	//이미 깨진계란이면 패스
				//다른계란을 내리치고(내구도감소)
				s[index] -= w[i];
				s[i] -= w[index];
				int tempCnt = 0;//현재작업으로 깨진 계란의수
				if(s[i]<=0) tempCnt++;
				if(s[index]<=0) tempCnt++;
				dfs(index + 1,cnt + tempCnt);
				//다른계란을 안깬상태로 복구(내구도복구)
				s[index] += w[i];
				s[i] += w[index];
			}
		}
	}

}
