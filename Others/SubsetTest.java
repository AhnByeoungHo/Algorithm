package work20200128;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SubsetTest {

	public static void main(String[] args) {

		//Subset using bit operator
		PrintStream ps = System.out;
		//int[] arr = {1,2,3,4};
		char[] arr = {'A','B','C','D'};
		
		for(int i=0;i<(1<<arr.length);i++) {
			ps.print(Integer.toBinaryString(i) + "\t:\t");
			List<Character> subset = new ArrayList<>();
			for(int j=0;j<arr.length;j++) {
				if((i&(1<<j)) != 0) {
					subset.add(arr[j]);
				}
			}
			ps.println(subset);
		}
		ps.println();
		
		//Subset Sum Problem
		ps.println("Subset Sum Problem");
		int[] set = {-7,-3,-2,5,8};
		
		for(int i=0;i<(1<<set.length);i++) {
			List<Integer> subset = new ArrayList<>();
			for(int j=0;j<set.length;j++) {
				if((i&(1<<j)) != 0) {
					subset.add(set[j]);
				}
			}
			int sum = 0;
			for(int s=0;s<subset.size();s++) {
				sum += subset.get(s);
			}
			if(sum==0 & subset.size()!=0) {
				ps.print("subset " + subset);
				ps.println(" 가 있으므로 참입니다.");
				break;
			}
		}
		
	}

}
