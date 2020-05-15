package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_1941 {
	static ArrayList<person> arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String l = br.readLine();
			for (int j = 0; j < 5; j++) {
				arr.add(new person(i, j, l.charAt(j)));
			}
		}
		person[] seven = new person[7];
		for (int i = 0; i < 7; i++) {
			seven[i] = new person(0, 0, '0');
		}
		dfs(0, 0, seven);
		System.out.println(ans);
	}

	public static void dfs(int depth,int start, person[] seven){
		if(depth==7){
			int isS = 0;
			for (int i = 0; i < 7; i++) {
				if(seven[i].type=='S')
					isS++;
			}
			if(isS>=4){
				//확장
				Queue<int[]> q = new LinkedList<int[]>();
				boolean[][] visit = new boolean[5][5];
				q.add(new int[]{seven[0].x,seven[0].y});
				visit[seven[0].x][seven[0].y] = true;

				while(!q.isEmpty()){
					int[] cur = q.poll();
					int curx = cur[0];
					int cury = cur[1];

					for (int dir = 0; dir < 4; dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						if(nx<0||ny<0||nx>=5||ny>=5) continue;
						if(visit[nx][ny]) continue;
						boolean isin = false;
						for (int i = 0; i < 7; i++) {
							if(nx==seven[i].x && ny==seven[i].y){
								isin = true;
								break;
							}
						}
						if(isin){
							q.add(new int[]{nx,ny});
							visit[nx][ny] = true;
						}
					}
				}
				int c = 0;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if(visit[i][j]) {
							c++;
							//System.out.print(1);
						}
						//else System.out.print(0);
					}
					//System.out.println();
				}
				//System.out.println();
				if(c==7) ans++;
			}
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			//System.out.println(arr.get(i));
			seven[depth] = new person(arr.get(i).x, arr.get(i).y , arr.get(i).type);
			dfs(depth+1, i+1, seven);
		}
	}
	static class person{
		int x;
		int y;
		char type;
		public person(int x, int y, char type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
		@Override
		public String toString() {
			return "person [x=" + x + ", y=" + y + ", type=" + type + "]";
		}
		
	}
}

