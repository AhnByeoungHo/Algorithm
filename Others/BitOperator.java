package work20200128;

import java.io.PrintStream;

public class BitOperator {

	public static void main(String[] args) {
		// Shift operator << >>
		PrintStream ps = System.out;
		int num1 = 10;
		
		ps.println(num1 + " : " + Integer.toBinaryString(num1));
		ps.println((num1<<1)+" : "+(Integer.toBinaryString(num1<<1)));
		ps.println((num1>>1)+" : "+(Integer.toBinaryString(num1>>1)));
		
		
		//Bit masking operator 
		int status = 1; // int is 32bit, each bit is 1 or 0 -> boolean -> it can using subset
		int student1 = 1;
		// subset to using & operator
		ps.println("Student1 is in? " + (status&student1));
		// make subset
		ps.println("Student1 to subset " + (status|student1));
		
		ps.println("현재상태 " +  Integer.toBinaryString(status));
		int student2 = 0b100; // binary in java
		ps.println("포함? " + (status&student2));
		status |= student2;
		ps.println("현재상태 " +  Integer.toBinaryString(status));
		
		//odd or even
		int oddnum = 13;
		int evennum = 14;
		int mask = 1;
		ps.println("If odd " + (oddnum&mask));
		ps.println("If even " + (evennum&mask));
		
		
		
	}

}
