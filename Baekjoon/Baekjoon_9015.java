package bak20200205;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_9015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			Stack<Integer> s = new Stack();
			int flag = 2,cnt = 0;
			for(int i=0;i<N;i++) {
				int num = sc.nextInt();
				if(s.size()<=1||num==s.peek()) {
					s.push(num);
					//System.out.println(s.toString());
				}
				else if(num>s.peek()) {
					if(flag == 0) {
						cnt++;
						s.clear();
						s.push(num);
						flag = 2; 
						//System.out.println(s.toString() + ":"+flag);
						continue;
					}
					else
						s.push(num);
				}
				else if(num<s.peek()){
					if(flag == 1) {
						cnt++;
						s.clear();
						s.push(num);
						flag = 2;
						//System.out.println(s.toString() + ":"+flag);
						continue;
					}
					else
						s.push(num);
				}
				if(s.size()>=2) {
					if(s.get(s.size()-1)>s.get(s.size()-2)) {
						flag = 1;
					}
					else if(s.get(s.size()-1)<s.get(s.size()-2))
						flag = 0;
					else if(flag!=0&&flag!=1)
						flag = 2;
				}
				//System.out.println(s.toString() + ":"+flag);
			}
			System.out.println("#"+tc+" " + (cnt+1));
		}
	}

}
