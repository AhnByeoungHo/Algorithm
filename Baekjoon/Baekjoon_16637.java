package bak;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_16637 {

	private static int N;
	private static int[] num;
	private static char[] oper;
	private static boolean[] subset;
	private static boolean[] child = {true, false};
	private static int MAX;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N/2+1];
		oper = new char[N/2];
		String line = sc.next();
		for(int i=0,n=0;i<line.length();i++){
			if(i%2==0) num[n++] = line.charAt(i)-'0';
			else oper[i/2] = line.charAt(i);
		}
		subset = new boolean[N/2];
		MAX = num[0];
		if(N==1){
			System.out.println(MAX);
		}
		else if(N==3){
			for(int i=0;i<N/2;i++){
				if(oper[i]=='+'){
					MAX = MAX + num[i+1];
				}else if(oper[i]=='-'){
					MAX = MAX - num[i+1];
				}else if(oper[i]=='*'){
					MAX = MAX * num[i+1];
				}
			}
			System.out.println(MAX);
		}
		else {
			for(int i=0;i<N/2;i++){
				if(oper[i]=='+'){
					MAX = MAX + num[i+1];
				}else if(oper[i]=='-'){
					MAX = MAX - num[i+1];
				}else if(oper[i]=='*'){
					MAX = MAX * num[i+1];
				}
			}
			powerSet(0);
			//		System.out.println(Arrays.toString(num));
			//		System.out.println(Arrays.toString(oper));
			System.out.println(MAX);
		}
		
	}
	public static void powerSet(int depth){
		if(depth==N/2){
			boolean cando = true;
			for(int i=0;i<N/2;i++){
				if(subset[i]){
					if(i==0&&subset[1]){
						cando = false;
					}
					else if(i==N/2-1&&(subset[N/2-2])){
						cando = false;
					}
					else if(i<N/2-1&&i>0&&(subset[i+1]||subset[i-1])){
						cando = false;
					}

				}
			}	
			if(cando){
				Stack<Integer> s = new Stack<>();
				s.push(num[0]);
				for(int i=0;i<N/2;i++){
					if(subset[i]){

						int temp=s.pop();
						if(oper[i]=='+'){
							temp = temp + num[i+1];
						}else if(oper[i]=='-'){
							temp = temp - num[i+1];
						}else if(oper[i]=='*'){
							temp = temp * num[i+1];
						}
						s.push(temp);
					}
					else if(i<N/2-1&&i>0&&(subset[i+1])){
						s.push(num[i+1]);

					}
					else{
						s.push(num[i+1]);
					}
				}

				Stack<Integer> temp = new Stack<>();
				while(!s.isEmpty()){
					temp.push(s.pop());
				}
				int x=0;
				int result = 0;
				if(!temp.isEmpty())
					result = temp.pop();
				while(!temp.isEmpty()){
					if(!subset[x]){
						int t = temp.pop();
						if(oper[x]=='+'){
							result = result + t;
						}else if(oper[x]=='-'){
							result = result - t;
						}else if(oper[x]=='*'){
							result = result * t;
						}
					}
					x++;
					if(x==N/2) break;

				}
				//System.out.println(temp.toString());
				//System.out.println(" = "+result);
				MAX = Math.max(result, MAX);
			}

			return;
		}
		else{
			for(int i=0;i<2;i++){
				subset[depth] = child[i];
				powerSet(depth+1);
			}
		}
	}

}
