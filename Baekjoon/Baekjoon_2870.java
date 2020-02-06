package bak20200206;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 6.
 * @see https://www.acmicpc.net/problem/2870
 * @mem
 * @time
 * @caution
 * 
 * */


public class Baekjoon_2870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Character> q = new Stack();
		ArrayList<BigInteger> arr  = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<str.length();j++) {
				char c = str.charAt(j);
				//System.out.println(c);

				if((c-'0')>=0&&(c-'0')<=9) {
					q.push(c);
					if(j==(str.length()-1)) {
						BigInteger x = BigInteger.ONE;
						BigInteger num= BigInteger.ZERO;
						while(!q.isEmpty()) {
							//System.out.print(q.pop());
							BigInteger temp = (BigInteger.valueOf((q.pop()-'0'))).multiply(x);
							//System.out.println(temp + " "+num + " "+x);
							num = num.add(temp);
							x = x.multiply(BigInteger.TEN);
							
						}
		
						arr.add(num);
					}
				}
				else {
					if(!q.isEmpty()) {
						BigInteger x = BigInteger.ONE;
						BigInteger num= BigInteger.ZERO;
						while(!q.isEmpty()) {
							BigInteger temp = (BigInteger.valueOf((q.pop()-'0'))).multiply(x);
							//System.out.println(temp + " "+num + " "+x);
							num = num.add(temp);
							x = x.multiply(BigInteger.TEN);;
						}
						arr.add(num);
						//System.out.println();
					}
				}
			}
			//System.out.println("===");
		}
		Collections.sort(arr);
			
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}

}
