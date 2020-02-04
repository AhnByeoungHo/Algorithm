package work20200204;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	static String src = "1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sp = src.split(" ");
		PriorityQueue<Point> pointq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				Integer w1 = o1.weight;
				Integer w2 = o2.weight;
				Integer from1 = o1.from;
				Integer from2 = o2.from;
				if(!w1.equals(w2))
					return w2.compareTo(w1);
				else
					return from1.compareTo(from2);
			}
		});
		
		for(int i=0;i<sp.length;i+=3) {
			pointq.offer(new Point(sp[i],sp[i+1],sp[i+2]));
		}
		while(!pointq.isEmpty()) {
			System.out.println(pointq.poll());
		}
	}
	static class Point {
		int from;
		int to;
		int weight;
		Point(String x, String y, String weight){
			this.from = Integer.parseInt(x);
			this.to = Integer.parseInt(y);
			this.weight = Integer.parseInt(weight);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return from + "->" + to + "\t(weight" + weight +")";
		}
		
	}

}
