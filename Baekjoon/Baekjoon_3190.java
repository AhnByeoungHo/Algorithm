package bak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon_3190 {

	private static int N;
	private static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy  ={0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int K = sc.nextInt();
		for(int k=0;k<K;k++){
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map[x][y] = 2;
		}
		int orderNum = sc.nextInt();
		Order[] oList = new Order[orderNum];
		for(int order=0;order<orderNum;order++){
			int time = sc.nextInt();
			char dir = sc.next().charAt(0);
			oList[order] = new Order(time, dir);
		}
		
		int ans = 0;
		int oidx = 0;
		Snake s = new Snake();
		s.add(0, 0);
		map[0][0] = 1;
		s.dir = 1;
		
		while(true){
			//System.out.println(ans + ":"+ s.sn);
			int headx = s.sn.get(s.sn.size()-1).x;
			int heady = s.sn.get(s.sn.size()-1).y;
			int dir = s.dir;
			
			int nx = headx + dx[dir];
			int ny = heady + dy[dir];
			
			if(nx<0||ny<0||nx>=N||ny>=N){
				break;
			}
			if(map[nx][ny]==1){
				break;
			}
			if(map[nx][ny]==0){
				s.add(nx, ny);
				map[s.sn.get(0).x][s.sn.get(0).y] = 0;
				s.remove();
			}
			else if(map[nx][ny]==2){
				s.add(nx, ny);
				map[nx][ny] = 0;
			}
			
			ans++;
			if(oidx<orderNum&&ans==oList[oidx].time){
				s.changeDir(oList[oidx].dir);
				dir = s.dir;
				oidx++;
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j] == 1)
						map[i][j] = 0;
				}
			}
			for(int i=0;i<s.sn.size();i++){
				map[s.sn.get(i).x][s.sn.get(i).y] = 1;
			}
		}
		System.out.println(ans+1);
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + "," + y;
		}
		
	}
	static class Order{
		int time;
		char dir;
		public Order(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
		
	}
	static class Snake{
		LinkedList<Pair> sn;
		int dir;//상우하좌
		public Snake() {
			sn = new LinkedList<>();
		}
		public void add(int x, int y){
			sn.add(new Pair(x,y));
		}
		public void remove(){
			sn.remove(0);
		}
		public void changeDir(char dir){
			if(dir=='L'){//90도 왼쪽
				this.dir = (this.dir+3)%4;
			}
			else if(dir=='D'){//90도 오른쪽
				this.dir = (this.dir+1)%4;
			}
		}
	}

}
