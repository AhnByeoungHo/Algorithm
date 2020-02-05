package com.computer;

public class Mouse {
	String maker;
	boolean wireless;

	public Mouse(String string, boolean b) {
		this.maker = string;
		this.wireless = b;
	}
	void leftClick() {
		System.out.println("mouse left click");
	}
	void rightClick() {
		System.out.println("mouse right click");
	}
	void wheeling() {
		System.out.println("mouse wheeling");
	}
	void info() {
		System.out.println("MOUSE");
		System.out.println("maker: " + maker);
		System.out.println("wireless: " + wireless);
		System.out.println("----------------");
	}
}
