package bak20200130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Baekjoon_14502 {

	static ArrayList<Integer> storePermute = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] copy = new int[n][m];
		
		ArrayList<Point> canWall = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0) {
					canWall.add(new Point(i,j));
				}
					
			}
		}
		
		int[] output=new int[3];
		chooseThree(canWall.size(), 0, output);
		
		int max = 0;
		for(int i=0;i<storePermute.size();i+=3) {
			copy = mapCopy(map, copy);
			Point p1 = canWall.get(storePermute.get(i));
			Point p2 = canWall.get(storePermute.get(i+1));
			Point p3 = canWall.get(storePermute.get(i+2));
			copy[p1.x][p1.y] =1;
			copy[p2.x][p2.y] =1;
			copy[p3.x][p3.y] =1;
			
			int[][] visit = new int[n][m];
			Queue<Point> q = new LinkedList<>();
			for(int a=0;a<n;a++) {
				for(int b=0;b<m;b++) {
					if(copy[a][b]==2) {
						q.add(new Point(a,b));
					}
				}
			}
			while(!q.isEmpty()) {
				Point temp = q.poll();
				int curx = temp.x;
				int cury = temp.y;
				//System.out.println(curx + " "+cury);
				if(copy[curx][cury]==2) {
					for(int dir=0;dir<4;dir++) {
						int nx = curx + dx[dir];
						int ny = cury + dy[dir];
						//System.out.println(nx+" "+ny);
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(copy[nx][ny]!=0 ||visit[nx][ny]==1) continue;
						visit[nx][ny] = 1;
						copy[nx][ny] = 2;
						q.add(new Point(nx,ny));
					}
				}
				//printMap(copy);
				//System.out.println("=======");
			}
			
			int count = zeroCount(copy);
			if(max<count) max = count;
		}
		System.out.println(max);
		
	}
	public static void printMap(int[][] arr){

		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
	public static int zeroCount(int[][] arr){
		int count = 0;
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr[0].length;j++)
				if(arr[i][j]==0)
					count++;
		return count;
	}
	public static int[][] mapCopy(int[][] ori , int[][] copy) {
		for(int i=0;i<ori.length;i++) {
			for(int j=0;j<ori[0].length;j++) {
				copy[i][j] = ori[i][j];
			}
		}
		return copy;
	}
	public static void chooseThree(int n,int depth,int[] output) {
		if(depth==3) {
			if(output[0]<output[1]&&output[1]<output[2]) {
				for(int i=0;i<3;i++) {
					storePermute.add(output[i]);
				}
				return;
			}
		}
		else {
			for(int i=0;i<n;i++) {
				output[depth] = i;
				chooseThree(n, depth+1, output);
			}
		}
	}
}
