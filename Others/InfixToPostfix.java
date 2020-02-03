package work20200203;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "(6+5*(2-8)/2)";
		//String data = "2+3*4/5";
		char[] cdata = data.toCharArray();
		Stack s = new Stack();
		String postFix = "";
		
		for(int i=0;i<cdata.length;i++) {
			char c = cdata[i];
			if(c-'0'>=0&&c-'0'<=9) {
				System.out.print(c);
				postFix+=c;
			}
			else if(getOrder(c)==2) s.push(c);
			else if(getOrder(c)==1) {
				if(s.isEmpty()) {s.push(c); continue;}
				
				char t = (char) s.peek();
				while(getOrder(t)!=2) {
					t = (char) s.pop();
					if(t!='(') {
						System.out.print(t);
						postFix+=t;
					}
				}			
			}
			else {
				if(s.isEmpty()) {s.push(c); continue;}
				char temp = (char) s.peek();
				if(getOrder(c)>getOrder(temp)) s.push(c);
				else {
					while(true) {
						
						temp = (char) s.peek();
						if(getOrder(c)>getOrder(temp)) {
							break;
						}
						else {
							System.out.print(temp);
							postFix += temp;
							s.pop();
						}
					}
					s.push(c);
				}
								
			}
			System.out.println("\t"+c+": "+s.toString());
		}
		System.out.println(postFix);
		cal(postFix);
	}
	public static int getOrder(char c) {
		if(c=='*'||c=='/') return 4;
		else if(c=='+'||c=='-') return 3;
		else if(c=='(') return 2;
		else if(c==')') return 1;
		else return 0;
	}
	public static void cal(String postFix) {
		char[] cdata = postFix.toCharArray();
		Stack<Integer> s = new Stack();
		for(int i=0;i<cdata.length;i++) {
			char c = cdata[i];
			if(getOrder(c)==0) s.push(cdata[i]-'0');
			else {
				int second = s.pop();
				int first = s.pop();
				
				if(c=='*') s.push((first)*(second));
				else if(c=='/') s.push((first)/(second));
				else if(c=='+') s.push((first)+(second));
				else if(c=='-') s.push((first)-(second));
			}
			System.out.println(s.toString());
		}
		System.out.println(s.pop());
			
		
	}

}
