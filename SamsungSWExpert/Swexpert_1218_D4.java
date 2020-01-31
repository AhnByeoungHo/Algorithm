package bak20200131;

import java.util.Scanner;
import java.util.Stack;

public class Swexpert_1218_D4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int len = sc.nextInt();
			String str = sc.next();
			boolean end = false;
			Stack<Character> s = new Stack<>();
			for(int i=0;i<len;i++) {
				char c = str.charAt(i);
				if(c=='(') s.push(c);
				else if(c=='[') s.push(c);
				else if(c=='{') s.push(c);
				else if(c=='<') s.push(c);
				
				else if(c==')') {
					if(s.isEmpty()||s.peek()!='(') {
						end = true;
						break;
					}
					s.pop();
				}
				else if(c==']') {
					if(s.isEmpty()||s.peek()!='[') {
						end =true;
						break;
					}
					s.pop();
				}
				else if(c=='}') {
					if(s.isEmpty()||s.peek()!='{') {
						end = true;
						break;
					}
					s.pop();
				}
				else if(c=='>') {
					if(s.isEmpty()||s.peek()!='<') {
						end = true;
						break;
					}
					s.pop();
				}
			}
			if(!s.isEmpty()||end==true) {
				System.out.println("#"+tc+" 0");
			}
			else
				System.out.println("#"+tc+" 1");
		}
	}

}
