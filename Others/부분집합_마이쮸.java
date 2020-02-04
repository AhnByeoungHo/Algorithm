package work20200204;

import java.util.LinkedList;
import java.util.Queue;

public class 부분집합_마이쮸 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Person> q = new LinkedList<>();
		
		int mychuNum = 20;
		int N = mychuNum/2 + 5;
		
		Person[] parr = new Person[N];
		for(int i=0;i<N;i++) {
			parr[i] = new Person(i+1);
		}

		int sum = 0;
		int id = 0;
		while(true) {
			q.offer(parr[id++]);
			parr[q.peek().id-1].mplus();
			System.out.println(parr[q.peek().id-1].id+" eat "+parr[q.peek().id-1].mnum);
			sum=0;
			for(int i=0;i<N;i++) {
				sum+=parr[i].sum;
			}
			if(sum>= mychuNum) {
				System.out.println(q.peek().id+" get mychu");
				break;
			}
			q.offer(q.poll());
		}
		System.out.println();
		for(int i=0;i<N;i++) {
			if(parr[i].mnum==0)break;
			System.out.println(parr[i]);
		}
	}
	static class Person{
		int id;
		int mnum=0;
		int sum = 0;
		Person(int id){
			this.id = id;
		}
		void mplus() {
			mnum++;
			sum+=mnum;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return id+":"+sum;
		}
	}
}
