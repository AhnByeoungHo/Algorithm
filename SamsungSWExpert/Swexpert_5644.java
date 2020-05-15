package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swexpert_5644 {
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			
			int mvtime = Integer.parseInt(st.nextToken());
			int[] amove = new int[mvtime+1];
			int[] bmove = new int[mvtime+1];
			
			int bcNum = Integer.parseInt(st.nextToken());
			int[][][] map = new int[bcNum][10][10];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < mvtime+1; i++) {
				amove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < mvtime+1; i++) {
				bmove[i] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<bc> bclist = new ArrayList<>();
			for (int i = 0; i < bcNum; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bclist.add(new bc(x, y, c, p, i));
				map[i][x][y] = p;
			}
			
			for (int b = 0; b <bcNum ; b++) {
				boolean[][] visit = new boolean[10][10];
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(map[b][i][j]!=0 && !visit[i][j]){
							Queue<int[]> q = new LinkedList<int[]>();
							
							q.add(new int[]{i,j,0});
							visit[i][j] = true;
							
							while(!q.isEmpty()){
								int[] cur = q.poll();
								int curx = cur[0];
								int cury = cur[1];
								int curdepth = cur[2];
								if((curdepth)>bclist.get(b).c-1) break;
								for (int dir = 1; dir < 5; dir++) {
									int nx = curx + dx[dir];
									int ny = cury + dy[dir];
									if(nx<0||ny<0||nx>=10||ny>=10) continue;
									if(visit[nx][ny]) continue;
									
									q.add(new int[]{nx,ny,curdepth+1});
									visit[nx][ny] = true;
									map[b][nx][ny] = map[b][curx][cury];
								}	
							}
						}
					}
				}
			}
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Arrays.toString(map[0][i]));
//			}
//			System.out.println();
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Arrays.toString(map[1][i]));
//			}
//			System.out.println();
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Arrays.toString(map[2][i]));
//			}
//			System.out.println();
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Arrays.toString(map[3][i]));
//			}
			
			int ax = 0;
			int ay = 0;
			int bx = 9;
			int by = 9;
			
			int totala=0;
			int totalb=0;
			for (int i = 0; i < mvtime+1; i++) {
				int adir = amove[i];
				int bdir = bmove[i];
				
				ax = ax + dx[adir];
				ay = ay + dy[adir];
				bx = bx + dx[bdir];
				by = by + dy[bdir];
				
				int acost = 0;
				int bcost = 0;
				//System.out.println(ax + " " + ay);
				if(ax==bx && ay==by){
					//균등분배 혹은 따로따로 고려
					ArrayList<Integer> temp = new ArrayList<>();
					for (int b = 0; b < bcNum; b++) {
						//같은 b이면은 균등
						if(map[b][ax][ay]!=0) temp.add(map[b][ax][ay]);
					}
					if(temp.size()==0){
						continue;
					} else if(temp.size()==1){
						acost = temp.get(0)/2;
						bcost = temp.get(0)/2;
					} else {
						temp.sort(new Comparator<Integer>() {

							@Override
							public int compare(Integer o1, Integer o2) {
								// TODO Auto-generated method stub
								return o1.compareTo(o2);
							}
						});
						
						acost = temp.get(temp.size()-1);
						bcost = temp.get(temp.size()-2);
						
					}
				}
				else {
					int aid=0;
					int bid=0;
					for (int b = 0; b < bcNum; b++) {
						if(acost<map[b][ax][ay]){
							acost = map[b][ax][ay];
							aid = b;
						}
						if(bcost<map[b][bx][by]){
							bcost = map[b][bx][by];
							bid = b;
						}
						
					}
					if(aid==bid && acost!=0 && bcost!=0){
						ArrayList<Integer> atemp = new ArrayList<>();
						ArrayList<Integer> btemp = new ArrayList<>();
						
						
						for (int b = 0; b < bcNum; b++) {
							if(map[b][ax][ay]!=0) atemp.add(map[b][ax][ay]);
						}
						for (int b = 0; b < bcNum; b++) {
							if(map[b][bx][by]!=0) btemp.add(map[b][bx][by]);
						}
						
						atemp.sort(new Comparator<Integer>() {

							@Override
							public int compare(Integer o1, Integer o2) {
								// TODO Auto-generated method stub
								return o1.compareTo(o2);
							}
						});
						btemp.sort(new Comparator<Integer>() {

							@Override
							public int compare(Integer o1, Integer o2) {
								// TODO Auto-generated method stub
								return o1.compareTo(o2);
							}
						});
						
						
						if(atemp.size()==1 && btemp.size()==1){
							acost /= 2;
							bcost /= 2;
						} else if(atemp.size()==1 && btemp.size()>1){
							bcost = btemp.get(btemp.size()-2);
						} else if(atemp.size()>1 && btemp.size()==1){
							acost = atemp.get(atemp.size()-2);
						} else if(atemp.size()>1 && btemp.size()>1){
							if(atemp.get(atemp.size()-1)+btemp.get(btemp.size()-2)>(atemp.get(atemp.size()-2)+btemp.get(btemp.size()-1))){
								acost = atemp.get(atemp.size()-1);
								bcost = btemp.get(btemp.size()-2);
							} else {
								acost = atemp.get(atemp.size()-2);
								bcost = btemp.get(btemp.size()-1);
							}
						}
					}
				}
				//System.out.println(i + ": "+acost + " "+bcost);
				totala+=acost;
				totalb+=bcost;
			}
			System.out.println("#" + tc + " " + (totala+totalb));
		}//tc
				
	}
	static class bc{
		int x;
		int y;
		int c;
		int p;
		int id;
		public bc(int x, int y, int c, int p, int id) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.id = id;
		}
		
	}
}
