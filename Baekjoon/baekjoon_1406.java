package bak20200128;

import java.util.ArrayList;
import java.util.Scanner;

//NOt solve
public class baekjoon_1406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i=0;i<str.length();i++) {
			arr.add(str.charAt(i));
		}
		int point = str.length();
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			String ldbp = sc.next();
			if(ldbp.equals("L")) {
				if(point != 0)
					point -= 1;
			}
			else if(ldbp.equals("D")) {
				if(point!=arr.size())
					point+=1;
			}
			else if(ldbp.equals("B")) {
				if(point!=0) {
					arr.remove(point-1);
					point -= 1;
				}
					
			}
			else if(ldbp.equals("P")) {
				String add = sc.next();
				if(point==arr.size()) {
					arr.add(add.charAt(0));
					point+=1;
				}
					
				else if(point!= 0)
					arr.add(point, add.charAt(0));
				else {
					arr.add(0,add.charAt(0));
				}
			}
		}
		for(int i=0;i<arr.size();i++)
			System.out.print(arr.get(i));
		
	}

}
