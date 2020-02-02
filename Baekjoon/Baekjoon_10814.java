package bak;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person{
	int age;
	String name;
	Person(int age,String name){
		this.age = age;
		this.name = name;
	}
}
public class Baekjoon_10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Person[] p = new Person[N];
		
		for(int i=0;i<N;i++){
			int age = sc.nextInt();
			String name = sc.next();
			p[i] = new Person(age,name);
		}
		
		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				Integer age1 = o1.age;
				Integer age2 = o2.age;
				if(!age1.equals(age2))
					return age1.compareTo(age2);
				else
					return 0;
			}
		});
		
		for(int i=0;i<N;i++){
			System.out.println(p[i].age + " " + p[i].name);
		}

	}

}
