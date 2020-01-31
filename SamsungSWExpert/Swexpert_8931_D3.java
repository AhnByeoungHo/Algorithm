package bak20200131;

import java.util.Scanner;
import java.util.Stack;

public class Swexpert_8931_D3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int ans = 0;
			int k=sc.nextInt();
			Stack<Integer> s = new Stack<>();
			for(int num=0;num<k;num++) {
				int val = sc.nextInt();
				if(val!=0) {
					s.push(val);
				}
				else s.pop();
			}
			while(!s.isEmpty()) {
				ans += s.pop();
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}
