package bak20200210;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Swexpert_1229_D3 {

	private static int N;
	private static int orderNum;

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			orderNum = sc.nextInt();
			int c =0;
			
	
			while(c<orderNum) {
				String order = sc.next();
				if(order.equals("I")) {
					int idx = sc.nextInt();
					int end = sc.nextInt();
					for(int i=idx;i<idx+end;i++) {
						list.add(i, sc.nextInt());
					}
					c++;
				}
				else if(order.equals("D")) {
					int idx = sc.nextInt();
					int end = sc.nextInt();
					for(int i=idx;i<idx+end;i++) {
						list.remove(idx);
					}
					c++;
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<10;i++)
				System.out.print(list.get(i)+ " ");
			System.out.println();
		}
	}

}
