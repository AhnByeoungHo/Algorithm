package bak20200219;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_17837 {

	private static int N;
	private static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	private static ArrayList[][] move;
	private static int K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][N];
		move = new ArrayList[N][N];
		ArrayList<horse> horseList = new ArrayList<>();

		for(int i=0;i<N;i++) {
			move[i] = new ArrayList[N];
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
				move[i][j] = new ArrayList<>();
			}
		}

		for(int i=0;i<K;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int dir = sc.nextInt()-1;
			horseList.add(new horse(i+1,x, y, dir));
			move[x][y].add(i+1);
		}

		int count = 0;
		boolean isend = false;
		while(true) {
			count++;
			//1~k번말 순서대로 한칸이동
			
			for(int i=0;i<K;i++) {
				
//				System.out.println(i+1+"move");
//				for(int a=0;a<N;a++) {
//					for(int b=0;b<N;b++) {
//						if(move[a][b].size()!=0)
//							System.out.print(move[a][b].get(move[a][b].size()-1)+"\t");
//						else System.out.print(0+"\t");
//					}
//					System.out.println();
//				}
//				System.out.println();
				horse curHorse = horseList.get(i);
				int curx = curHorse.x;
				int cury = curHorse.y;
				int curid = curHorse.id;
				int dir = curHorse.dir;
				ArrayList<Integer> curarr = new ArrayList<>();
				for(int m=0;m<move[curx][cury].size();m++) {
					curarr.add((Integer) move[curx][cury].get(m));
				}
				ArrayList<Integer> tomove = new ArrayList<>();//이동할 묶음
				//n번말 위에 무엇있는지 체크(nup)

				while(true) {
					if(curarr.isEmpty()) {
						break;
					}
					int num = curarr.get(curarr.size()-1);
					if(num==curid) {
						tomove.add(num);
						curarr.remove(curarr.size()-1);
						move[curx][cury].remove(move[curx][cury].size()-1);
						break;
					}
					else {
						tomove.add(num);
						curarr.remove(curarr.size()-1);
						move[curx][cury].remove(move[curx][cury].size()-1);
					}
				}
				//n번말 방향의 다음 칸 색깔 체크
				int nx = curx + dx[dir];
				int ny = cury + dy[dir];
				//맵벗어날때 방향 반대로 한후 이동 
				//이떄 이동하려는 칸이 파란색이면 이동은 안함
				if(nx<0||ny<0||nx>=N||ny>=N) {
					if(dir%2==0) {		
						horseList.get(curid-1).dir += 1;	
						dir++;
					}
					else {
						horseList.get(curid-1).dir -= 1;
						dir--;
					}
					nx = curx + dx[dir];
					ny = cury + dy[dir];
					if(map[nx][ny]!=2) {
						if(map[nx][ny]==0) {
							while(!tomove.isEmpty()) {
								move[nx][ny].add(tomove.get(tomove.size()-1));
								horseList.get(tomove.get(tomove.size()-1)-1).x = nx;
								horseList.get(tomove.get(tomove.size()-1)-1).y = ny;
								tomove.remove(tomove.size()-1);
							}
							if(move[nx][ny].size()>3) {

								isend = true;
								break;
							}
						}
						else {
							while(!tomove.isEmpty()) {
								move[nx][ny].add(tomove.get(0));
								horseList.get(tomove.get(0)-1).x = nx;
								horseList.get(tomove.get(0)-1).y = ny;
								tomove.remove(0);
							}
							
							if(move[nx][ny].size()>3) {

								isend = true;
								break;
							}
						}
					}
					else {
						while(!tomove.isEmpty()) {
							move[curx][cury].add(tomove.get(tomove.size()-1));
							tomove.remove(tomove.size()-1);
						}
					}
					
				}
				//0:흰색 일때 nup을 흰색 있는것 위에다올려놓기
				else if(map[nx][ny]==0) {
					//move[nx][ny].addAll(tomove);
					while(!tomove.isEmpty()) {
						move[nx][ny].add(tomove.get(tomove.size()-1));
						horseList.get(tomove.get(tomove.size()-1)-1).x = nx;
						horseList.get(tomove.get(tomove.size()-1)-1).y = ny;
						tomove.remove(tomove.size()-1);
					}
					if(move[nx][ny].size()>3) {

						isend = true;
						break;
					}
				}
				//1:빨간색일때 nup을 reverse후 다음것에 올려놓기
				else if(map[nx][ny]==1) {
					while(!tomove.isEmpty()) {
						move[nx][ny].add(tomove.get(0));
						horseList.get(tomove.get(0)-1).x = nx;
						horseList.get(tomove.get(0)-1).y = ny;
						tomove.remove(0);
					}
					
					if(move[nx][ny].size()>3) {

						isend = true;
						break;
					}
				}
				//2:파란색일때 방향 반대로 한후 이동 
				//이떄 이동하려는 칸이 파란색이면 이동은 안함
				else if(map[nx][ny]==2){
					if(dir%2==0) {
						horseList.get(curid-1).dir += 1;
						dir++;
					}
					else {
						horseList.get(curid-1).dir -= 1;
						dir--;
					}
					nx = curx + dx[dir];
					ny = cury + dy[dir];
					if(nx>=0&&ny>=0&&nx<N&&ny<N&&map[nx][ny]!=2) {
						if(map[nx][ny]==0) {
							while(!tomove.isEmpty()) {
								move[nx][ny].add(tomove.get(tomove.size()-1));
								horseList.get(tomove.get(tomove.size()-1)-1).x = nx;
								horseList.get(tomove.get(tomove.size()-1)-1).y = ny;
								tomove.remove(tomove.size()-1);
							}
							if(move[nx][ny].size()>3) {

								isend = true;
								break;
							}
						}
						else {
							while(!tomove.isEmpty()) {
								move[nx][ny].add(tomove.get(0));
								horseList.get(tomove.get(0)-1).x = nx;
								horseList.get(tomove.get(0)-1).y = ny;
								tomove.remove(0);
							}
							
							if(move[nx][ny].size()>3) {

								isend = true;
								break;
							}
						}
					}
					else {
						while(!tomove.isEmpty()) {
							move[curx][cury].add(tomove.get(tomove.size()-1));
							tomove.remove(tomove.size()-1);
						}
					}
				}
				//턴진행중 말이 4개이상쌓이면 종료
				if(isend) 
					break;
			}//endfor
			if(isend) 
				break;
			if(count>1000) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
	static class horse{
		int id,x,y;
		int dir;
		public horse(int id,int x, int y, int dir) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
