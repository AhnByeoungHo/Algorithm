package work20200203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Dfs {
	static Stack<Integer> st = new Stack();
	static boolean[] visit;
	static List<Integer> path;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
		List<Integer>[] arr = new List[8];
		
		arr = graph_List(src);
		System.out.println("============");
		dfsStack(1, arr);
		System.out.println();
		System.out.println(path.toString());
		
		System.out.println("============");
		visit = new boolean[8];
		path = new ArrayList<>();
		dfsRecur(1, arr);
		System.out.println();
		System.out.println(path.toString());
		
		
	}
	public static void dfsStack(int start,List<Integer>[] g) {
		visit = new boolean[8];
		path = new ArrayList<>();
		st = new Stack<>();
		
		st.push(start);
		while(!st.isEmpty()) {
			Integer top = st.pop();
			if(visit[top]) continue;
			visit[top] = true;
			System.out.print(top);
			path.add(top);
			List<Integer> childs = g[top];
			for(int i=childs.size()-1;i>=0;i--) {
				Integer child = childs.get(i);
				if(!visit[child]) {
					st.push(child);
				}
			}
		}
	}
	public static void dfsRecur(int start, List<Integer>[] g) {
		if(!visit[start]) {
			visit[start] = true;
			System.out.print(start);
			path.add(start);
			List<Integer> childs = g[start];
			for(int i=0;i<childs.size();i++) {
				Integer child = childs.get(i);
				if(!visit[child]) {
					dfsRecur(child, g);
				}
			}
		}
	}

	public static List<Integer>[] graph_List(String src) {
		String[] s = src.split(" ");
		
		List<Integer>[] arr = new List[8];
		for(int i=0;i<arr.length;i++)
			arr[i] = new ArrayList<Integer>();
		
		for(int i=0;i<s.length;i+=2) {
			arr[Integer.parseInt(s[i])].add(Integer.parseInt(s[i+1]));
			arr[Integer.parseInt(s[i+1])].add(Integer.parseInt(s[i]));
		}
		for(List<Integer> list : arr) {
			System.out.println(list);
		}
		return arr;
	}

}
