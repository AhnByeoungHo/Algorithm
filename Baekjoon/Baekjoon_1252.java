package bak20200130;

import java.util.Scanner;

public class Baekjoon_1252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String result="";
		s1 = reverse(s1);
		s2 = reverse(s2);
		int s1len = s1.length();
		int s2len = s2.length();
		int shortlen = s1len>s2len? s2len:s1len;
		int longlen = s1len>s2len? s1len:s2len;
		if(shortlen == s1.length()) {
			for(int i=shortlen;i<longlen;i++) {
				s1+= '0';
			}
		}
		else if(shortlen == s2.length()) {
			for(int i=shortlen;i<longlen;i++) {
				s2+= '0';
			}
		}
//		System.out.println(s1);
//		System.out.println(s2);
		int carry=0;
		for(int i=0;i<longlen;i++) {
			if(s1.charAt(i)=='0'&&s2.charAt(i)=='0') {
				if(carry == 0) {
					result+='0';
					carry=0;
				}
				else {
					result+='1';
					carry=0;
				}
			}
			else if((s1.charAt(i)=='0'&&s2.charAt(i)=='1')
					||s1.charAt(i)=='1'&&s2.charAt(i)=='0') {
				if(carry == 0) {
					result+='1';
					carry=0;
				}
				else {
					result+='0';
					carry=1;
				}		
			}
			else if(s1.charAt(i)=='1'&&s2.charAt(i)=='1') {
				if(carry == 0) {
					result+='0';
					carry=1;
				}
				else {
					result+='1';
					carry=1;
				}	
			}
		}
		if(carry==1) result += '1';
		
		//System.out.println(result);
		result = reverse(result);
		if(result.length()==1) {
			System.out.println(result);
		}
		else {
			int here=-1;
			for(int i=0;i<result.length();i++) {
				if(result.charAt(i)=='1') {
					here = i;
					break;
				}
			}
			if(here==-1) {
				System.out.println("0");
				return;
			}
			for(int i=here;i<result.length();i++) {
				System.out.print(result.charAt(i));
			}
		}
		
	}

	private static String reverse(String s) {
		String ret="";
		for(int i=0;i<s.length();i++) {
			ret+= s.charAt(s.length()-i-1);
		}
		return ret;
	}

}
