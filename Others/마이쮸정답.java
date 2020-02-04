package work20200204;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 마이쮸정답 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer,Integer> map = new HashMap<>();
		int candyCnt = 20;
		Queue<Person> q = new LinkedList<>();
		int pid = 1;
		q.offer(new Person(pid,1));
		
		int receivedCandyCnt = 0;
		while(true) {
			System.out.println("현재 큐 상태 : " + q);
			Person front = q.poll();
			receivedCandyCnt = front.mnum;
			front.mnum += 1;
			if(candyCnt <= receivedCandyCnt) {
				System.out.println(front.id + " 번이 마지막 캔디" + candyCnt +"개를 가져감");
				if(map.get(front.id)==null) {
					map.put(front.id, candyCnt);
				}
				else
					map.put(front.id, candyCnt + map.get(front.id));
				break;
			}
			else {
				candyCnt -= receivedCandyCnt;
				System.out.println(front.id + " 번이" + receivedCandyCnt +"개를 가져감 남은갯수:" + candyCnt);
				if(map.get(front.id)==null) {
					map.put(front.id, receivedCandyCnt);
				}
				else
					map.put(front.id, receivedCandyCnt + map.get(front.id));
				q.offer(front);
				q.offer(new Person(++pid,1));
			}
		}
		System.out.println(map.toString());
	}
	static class Person{
		int id;
		int mnum=0;
		Person(int id,int candy){
			this.id = id;
			this.mnum = candy;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id+":"+ mnum;
		}
	}

}
