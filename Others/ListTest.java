package work20200204;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addSeq(new LinkedList<>());
		addSeq(new ArrayList<>());
		addNonSeq(new LinkedList<>());
		addNonSeq(new ArrayList<>());
	}
	public static void addSeq(List<Integer> list) {
		long start = System.currentTimeMillis();
		for(int i=0;i<2000000;i++) {
			list.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(list.getClass().getName() + " : " + (end-start));
	}
	public static void addNonSeq(List<Integer> list) {
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			list.add(0,i);
		}
		long end = System.currentTimeMillis();
		System.out.println(list.getClass().getName() + " : " + (end-start));
	}


}
