package bak20200205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
	
		for(int tc=1;tc<=T;tc++) {
			char[] str = br.readLine().toCharArray();
			Stack first = new Stack();
			Stack second = new Stack();
			for(int i=0;i<str.length;i++) {
				char c = (str[i]);
				if(c=='<'&&!second.isEmpty()) {
					first.push(second.pop());
				}
				else if(c=='>'&&!first.isEmpty()) {
					second.push(first.pop());
				}
				else if(c=='-'&&!second.isEmpty()){
					second.pop();
				}
				else {
					if(c!='<'&&c!='>'&&c!='-') {
						second.push(c);
					}
				}
			}
			 while(!first.isEmpty()) {
	                second.push(first.pop());
	            }

			StringBuilder sb = new StringBuilder();
			for(int i=0;i<second.size();i++) {
				sb.append(second.elementAt(i));
			}
			System.out.println(sb);
		}
		
	}

}
