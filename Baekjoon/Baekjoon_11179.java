package bak20200206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author AhnByeoungHo
 * @since 2020. 2. 6.
 * @see https://www.acmicpc.net/problem/11179
 * @mem
 * @time
 * @caution
 * 
 * */



public class Baekjoon_11179 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long data = sc.nextLong();
		
		Stack<Long> s = new Stack();
		
		long num = data;
		while(true){
			s.push(num%2);
			num /= 2;
			if(num==0) break;
		}
		long result = 0;
		int i= 1;
		while(!s.isEmpty()) {
			result = result + i*s.pop();
			i = i*2;
		}
		System.out.println(result);
	}

}
