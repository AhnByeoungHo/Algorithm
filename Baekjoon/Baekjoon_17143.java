package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17143 {
	//상하우좌
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		int sharkNum = Integer.parseInt(st.nextToken());
		ArrayList<Shark> sharklist = new ArrayList<>();

		for (int i = 0; i < sharkNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());

			map[x][y] = weight;
			sharklist.add(new Shark(x, y, speed, dir, weight,true));
		}

		int catchsize = 0;

		for (int person = 0; person < M; person++) {
			for (int near = 0; near < N; near++) {
				if(near==N-1 && map[near][person]==0){
					for (int s = 0; s < sharklist.size(); s++) {
						if(sharklist.get(s).live){
							Shark mvshark = sharklist.get(s);
							int curx = mvshark.x;
							int cury = mvshark.y;

							map[curx][cury] = 0;

							int curspeed = mvshark.speed;
							int curdir = mvshark.dir;
							int size = mvshark.weight;

							int nx = curx;
							int ny = cury;
							int speed = curspeed;
							while(speed!=0){
								//System.out.println(nx+ " "+ny);
								nx = nx + dx[curdir];
								ny = ny + dy[curdir];
								if(nx<0) {
									curdir = 1;
									speed++;
									continue;
								}
								if(nx>=N) {
									curdir = 0;
									speed++;
									continue;
								}
								if(ny<0) {
									curdir = 2;
									speed++;
									continue;
								}
								if(ny>=M) {
									curdir = 3;
									speed++;
									continue;
								}
								speed--;
							}
							sharklist.get(s).x = nx;
							sharklist.get(s).y = ny;
							sharklist.get(s).speed = curspeed;
							sharklist.get(s).dir = curdir;
						}
					}
					map = new int[N][M];
					for (int s = 0; s <sharklist.size(); s++) {
						if(sharklist.get(s).live){
							Shark temp = sharklist.get(s);
							int curx = temp.x;
							int cury = temp.y;
							if(map[curx][cury]<temp.weight){
								if(map[curx][cury]!=0){
									for (int i = 0; i < sharklist.size(); i++) {
										if(sharklist.get(i).weight==map[curx][cury]){
											sharklist.get(i).live = false;
										}	
									}
								}
								map[curx][cury] = temp.weight;
							}
							else {
								sharklist.get(s).live=false;
							}
						}
					}
					break;
				}
				if(map[near][person]!=0){
					//catch
					catchsize += map[near][person];
					for (int s = 0; s < sharklist.size(); s++) {
						Shark catched = sharklist.get(s);
						if(catched.x==near && catched.y==person && catched.live){
							sharklist.get(s).live = false;
							break;
						}
					}
					map[near][person]=0;
					//move
					for (int s = 0; s < sharklist.size(); s++) {
						if(sharklist.get(s).live){
							Shark mvshark = sharklist.get(s);
							int curx = mvshark.x;
							int cury = mvshark.y;

							map[curx][cury] = 0;

							int curspeed = mvshark.speed;
							int curdir = mvshark.dir;
							int size = mvshark.weight;

							int nx = curx;
							int ny = cury;
							int speed = curspeed;
							while(speed!=0){
								//System.out.println(nx+ " "+ny);
								nx = nx + dx[curdir];
								ny = ny + dy[curdir];
								if(nx<0) {
									curdir = 1;
									speed++;
									continue;
								}
								if(nx>=N) {
									curdir = 0;
									speed++;
									continue;
								}
								if(ny<0) {
									curdir = 2;
									speed++;
									continue;
								}
								if(ny>=M) {
									curdir = 3;
									speed++;
									continue;
								}
								speed--;
							}
							sharklist.get(s).x = nx;
							sharklist.get(s).y = ny;
							sharklist.get(s).speed = curspeed;
							sharklist.get(s).dir = curdir;
						}
					}
					map = new int[N][M];
					for (int s = 0; s <sharklist.size(); s++) {
						if(sharklist.get(s).live){
							Shark temp = sharklist.get(s);
							int curx = temp.x;
							int cury = temp.y;
							if(map[curx][cury]<temp.weight){
								if(map[curx][cury]!=0){
									for (int i = 0; i < sharklist.size(); i++) {
										if(sharklist.get(i).weight==map[curx][cury]){
											sharklist.get(i).live = false;
										}	
									}
								}
								map[curx][cury] = temp.weight;
							}
							else {
								sharklist.get(s).live=false;
							}
						}
					}
					break;
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//
//			System.out.println(catchsize);
//			System.out.println();
		}
		System.out.println(catchsize);
	}
}
class Shark{
	int x;
	int y;
	int speed;
	int dir;
	int weight;
	boolean live;
	public Shark(int x, int y, int speed, int dir, int weight,boolean live) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.dir = dir;
		this.weight = weight;
		this.live = live;
	}

}
