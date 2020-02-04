package work20200204;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		
		System.out.println("Queue");
		for(int i=1;i<4;i++)
			q.offer(i*100);
		System.out.println(q.peek() + " "+ q.size());
		while(!q.isEmpty()) {
			System.out.println(q.poll() + " " + q.size());
		}
		System.out.println();
		
		PriorityQueue<String> s = new PriorityQueue<>();
		PriorityQueue<String> s2 = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				if(!len1.equals(len2))
					return len2.compareTo(len1);
				else return o2.compareTo(o1);
			}
			
		});
			
		System.out.println("Priority Queue original");
		s.offer("true");
		System.out.println(s.toString());
		s.offer("dream");
		System.out.println(s.toString());
		s.offer("is");
		System.out.println(s.toString());
		s.offer("come");
		System.out.println(s.toString());
		System.out.println(s.peek());
		System.out.println();
		
		while(!s.isEmpty()) {
			System.out.println(s.poll() + " " + s.size());
		}
		System.out.println();
		
		System.out.println("Priority Queue my comparator");
		s2.offer("true");
		System.out.println(s2.toString());
		s2.offer("dream");
		System.out.println(s2.toString());
		s2.offer("is");
		System.out.println(s2.toString());
		s2.offer("come");
		System.out.println(s2.toString());
		System.out.println(s2.peek());
		System.out.println();
		while(!s2.isEmpty()) {
			System.out.println(s2.poll() + " " + s2.size());
		}
		
	}

}
