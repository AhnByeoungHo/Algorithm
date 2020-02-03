package work20200203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "1 2 1 5 2 5 5 4 2 4 4 3 4 6 2 3";
		graph1(src);
		
		System.out.println("--------------");
		String src2 = "1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";
		graph2(src2);
		
		System.out.println("--------------");
		String src3 = "1 2 1 3 1 6 1 7 6 4 6 5 5 4 7 5";
		graph_List(src3);
		
		System.out.println("--------------");
		String src4 = "1 2 2 1 3 4 1 6 1 1 7 3 6 4 6 6 5 1 5 4 2 7 5 4";
		graph_List2(src4);
	}
	public static void graph1(String src) {
		int[][] g = new int[7][7];
		String[] s = src.split(" ");
		for(int i=0;i<s.length;i+=2) {
			g[Integer.parseInt(s[i])][Integer.parseInt(s[i+1])] = 1;
			//g[Integer.parseInt(s[i+1])][Integer.parseInt(s[i])] = 1;
		}
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(g[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void graph2(String src) {
		int[][] g = new int[7][7];
		String[] s = src.split(" ");
		for(int i=0;i<s.length;i+=3) {
			g[Integer.parseInt(s[i])][Integer.parseInt(s[i+1])] = Integer.parseInt(s[i+2]);
		}
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(g[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void graph_List(String src) {
		String[] s = src.split(" ");
		
		List<Integer>[] arr = new List[8];
		for(int i=0;i<arr.length;i++)
			arr[i] = new ArrayList<Integer>();
		
		for(int i=0;i<s.length;i+=2) {
			arr[Integer.parseInt(s[i])].add(Integer.parseInt(s[i+1]));
		}
		for(List<Integer> list : arr) {
			System.out.println(list);
		}
		
	}
	public static void graph_List2(String src) {
		String[] s = src.split(" ");
		
		List<Point>[] arr = new List[8];
		for(int i=0;i<arr.length;i++)
			arr[i] = new ArrayList<Point>();
		
		for(int i=0;i<s.length;i+=3) {
			arr[Integer.parseInt(s[i])].add(new Point(Integer.parseInt(s[i+1]),Integer.parseInt(s[i+2])));
		}
		for(List<Point> list : arr) {
			System.out.println(list);
		}
		
	}
	
	static class Point {
		int vId;
		int weight;
		Point(int v,int w){
			this.vId = v;
			this.weight = w;
		}
		@Override
		public String toString() {
			return "vIId=" + this.vId + " weight="+this.weight;
		}
	}

}
