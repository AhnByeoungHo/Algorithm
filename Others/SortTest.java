package work20200128;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = System.out;
		String [] strs = {"dream","is","come","true"};
		
		//Sorting by Ascii number
		Arrays.sort(strs);
		ps.println(Arrays.toString(strs));
		
		
		//Sorting by arrays len using Comparator
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				return len1.compareTo(len2);
			}
		});
		ps.println(Arrays.toString(strs));
		
		
		//If len is same I want to Sroting by Ascii Descent
		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				if(len1.equals(len2))
					return o2.compareTo(o1);
				else
					return len1.compareTo(len2);
			}
		});
		ps.println(Arrays.toString(strs));
	}

}
