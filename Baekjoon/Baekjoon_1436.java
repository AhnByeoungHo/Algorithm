import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		Integer i=665;
		while(true) {
			i++;
			String str = i.toString();
			if(str.contains("666"))
				arr.add(i);
			if(arr.size()==n) break;
				
		}
		System.out.println(arr.get(n-1));
	}

}
