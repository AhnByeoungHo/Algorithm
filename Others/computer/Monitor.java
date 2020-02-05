package com.computer;

public class Monitor {
	String maker;
	double size;
	
	public Monitor(String string, double d) {
		this.maker = string;
		this.size = d;
	}
	void powerOn() {
			System.out.println("monitor power on");
	}
	void powerOff() {
		System.out.println("monitor power off");
	}
	void info() {
		System.out.println("MONITOR");
		System.out.println("maker: " + maker);
		System.out.println("size: " + size);
		System.out.println("----------------");
	}
}
