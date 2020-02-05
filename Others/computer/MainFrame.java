package com.computer;

public class MainFrame {

	String maker;
	String cpu;

	public MainFrame(String string, String string2) {
		this.maker = string2;
		this.cpu = string;
	}

	void powerOn() {
		System.out.println("main frame power on");
	}
	void powerOff() {
		System.out.println("main frame power off");
	}
	public void info() {
		System.out.println("MAINFRAME");
		System.out.println("maker: " + maker);
		System.out.println("cpu: " + cpu);
		System.out.println("----------------");
	}
}
