package com.computer;

public class ComputerUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyComputer com = new MyComputer();
		//com.init();
		com.powerOn();
		com.doJob();
		com.powerOff();

		System.out.println("\n");
		System.out.println("Mycomputer Information");
		System.out.println("----------------------");
		com.info();
	}
}
